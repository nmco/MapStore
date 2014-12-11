/*
 *  Copyright (C) 2014 GeoSolutions S.A.S.
 *  http://www.geo-solutions.it
 *
 *  GPLv3 + Classpath exception
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
 
/**
 * @include src/mxp/widgets/geoCollect/xtype/XtypeTextField.js
 * @include src/mxp/widgets/geoCollect/xtype/XtypeTextArea.js
 * @include src/mxp/widgets/geoCollect/xtype/XtypeLabel.js
 * @include src/mxp/widgets/geoCollect/xtype/XtypeMap.js
 * @include src/mxp/widgets/geoCollect/xtype/XtypeSepIc.js
 * @include src/mxp/widgets/geoCollect/xtype/XtypeCheckBox.js
 * @include src/mxp/widgets/geoCollect/xtype/XtypeDateField.js
 * @include src/mxp/widgets/geoCollect/xtype/XtypeSeparator.js
 * @include src/mxp/widgets/geoCollect/xtype/XtypePhoto.js
 * @include src/mxp/widgets/geoCollect/xtype/XtypeActionSend.js
 * @include src/mxp/widgets/geoCollect/xtype/XtypeSpinner.js
 * @include src/mxp/widgets/geoCollect/MobileXtypeComboBox.js
 * @include src/mxp/widgets/geoCollect/MobileXDataTypeComboBox.js
 * **/

Ext.ns("mxp.widgets");


/**
 * GoeMobileWidgetPanel
 * Allow to create mobile widget
 * */
mxp.widgets.GcMobileWidgetPanel = Ext.extend(Ext.Panel, {

    /** api: xtype = mxp_gc_mobile_widget_panel */
	xtype:'mxp_gc_mobile_widget_panel',
    
    //Needed Store 
    seg_store:null,
    sop_store:null,
    wid_store:null,
    actions_store:null,
    sourceLabel:'Origin Fields',
    destLabel:'Mission Fields',
	//Utilizzat per ripulire i campi valori
	clV:new RegExp("^(\\${origin.)(.*)(})$"),

	layout: {
						type: 'hbox',
						align: 'stretch'
					},
 	border:false,
    frame:true,
    
initComponent: function() {
	

//TETX WIDGET OBJECT
this.objXtype={
		'label':	{"type":"text","xtype":"label","value":"macroarea","label":"Data Rilevazione"},
		'separatorWithIcon':{"type": null, "value": "${origin.gravita}", "label": "${origin.codice}", "xtype": "separatorWithIcon"},
		'mapViewPoint':{"type":"geoPoint","value":"${origin.the_geom}","xtype":"mapViewPoint","fieldId": "GEOMETRY","attributes":{
						"editable":false,"disablePan":true,"description":"${origin.RIFIUTI_NO}","height":640,"displayOriginalValue":true}},
		'textfield':{"fieldId": "NOME_RILEVATORE","type":"person","xtype":"textfield","value":"${local.user_name}","label":"Nome Rilevatore","mandatory":true},
        'textarea':{"fieldId": "NOME_RILEVATORE","type":"person","xtype":"textfield","label":"Nome Rilevatore","mandatory":true,"options":["Soggetto Pubblico","Soggetto Privato"]},
		'checkbox':{"type": null, "value": "INDIRIZZO", "label": "Cazzone", "xtype": "checkbox"}, 
		'datefield':{"fieldId": "DATA_AGG","type":"text","xtype":"datefield","label":"Data aggiornamento scheda"},
		'separator':{"type":"text","xtype":"separator","label":"Riepilogo"}
					};

this.xpanlForm=null;
this.dirty=false;//determina se la pagina è stata modificata!!

//Configuro lo store che conserva i widget creati e li mostra nella tabella il widget rimane nel dato raw
this.wid_store=new Ext.data.JsonStore({fields:['xtype','label','value','fieldId',{name:'_created',type:'boolean'}],proxy:new Ext.data.MemoryProxy()});

this.actions_store=[];
this.items=[ 
			{     
				ref:'widList',
				xtype:'grid',
				width: 340,
				title: "Page widgets",
				store: this.wid_store,
				autoScroll:true,
				style:{padding:'5px'},
				frame:true,
				cm: new Ext.grid.ColumnModel([
					{id: "name", header: "Xtype", dataIndex: "xtype", sortable: false},
					{id: "sop", header: "Field ID", dataIndex: "fieldId", sortable: false},
					{id: "seg", header: "Value", dataIndex: "value", sortable: false}
				 ]),
				 autoExpandColumn:'name',
				 sm: new	 Ext.grid.RowSelectionModel({singleSelect:true,
				 	listeners:{
				 		rowselect:function(slm,idx,r){
				 				console.log('row select');
				 				//Se è campo nuovo vado per costruzione filtri
				 			if(r.get('_created')) {
				 				if(this.setXtypeSelectorFilter()==0){ //Controllare se ho già un elemneto devo filtrare photo se ho già una action devo filtare action send	
			                    			  this.wid_store.remove(r);
			                    			  Ext.Msg.alert('Status', 'No widget available for this page!'); 
			                    			return;
			                    			}else{
			                    					r.beginEdit();//Vado in editing sul widget
				 									this.enableWidgetPanel();//Abiliti pannello editing
				 									this.loadXtype(r.json); //carichi nel pannello
			            							//slm.lock();//blocchi la selezione 	
			                    			}
			                    				
			                    		}else{	
			                    				//pulisco filtro e lo imposto come quello del campo in editing
			                    				
			                    
			                    				this.xtypeSelector.store.clearFilter();
			                    					this.xtypeSelector.store.filter('value',r.get('xtype'));
			                					if(this.xtypeSelector.store.getCount()==0){
		                    							 Ext.Msg.alert('Status', 'This is invalid widget for this page, remove!'); 
		                    							 this.enableWidgetPanel();}
			                    					else{
			                    					r.beginEdit();//Vado in editing sul widget
				 									this.enableWidgetPanel();//Abiliti pannello editing
				 									this.loadXtype(r.json); //carichi nel pannello
			            							//slm.lock();//blocchi la selezione 	
			            					}
			                    				
			                    			}
				 			
				 			
				 		
				 		},
				 		beforerowselect:function(sm,rowIndex,keepExisting,record){
				 			
				 			console.log('before select');
				 			
				 			if(this.xpanlForm.isDirty() && this.widList.getSelectionModel().getSelected()){
				 				
				 			
			                    			Ext.Msg.show({
  									 		title:'Save Widget?',
   											msg: 'Would you like to save your widget?',
  											 buttons: Ext.Msg.YESNOCANCEL,
   									fn: function(res){
   										
   										if(res=='yes'){
   											if(this.xpanlForm.isValid()===true){this.seveWidget();sm.selectRow(rowIndex)}
   											 else Ext.Msg.alert('Status', 'Invalid widget properties');  
   											
   										}else if(res=='no'){
   											rec = this.widList.getSelectionModel().getSelected();
   											
   											if(rec.get('_created')===true) this.wid_store.remove(rec);
   											
	   											
	   											this.widList.getSelectionModel().clearSelections();
	   											this.resetXpanel();
	   											this.disableWidgetPanel();
	   											sm.selectRow(rowIndex)
   											
   										}
   									},
   									scope:this,
   									animEl: 'elId',
  									icon: Ext.MessageBox.QUESTION
									});
			                    	
				 				
				 			}else return true;
				 			return false;
				 		}
				 		
				 		
				 		,scope:this
				 	}
				 	}),
			 	bbar:{
			 		xtype:'toolbar',
			 		items:[ {
			 					text:'Check Page',
               					ref:'/../ckPage',
			                    tooltip: 'Check Page Validity',
			                    iconCls: "accept",
			                    handler: function(btn){ 
			                    	Ext.Msg.alert('Status', 'Page valid:'+this.isValid()); 
			                    		                    	
			                    },scope:this},	'->' ,{
		       					ref:'/../addW',
			                    tooltip: 'Add widget',
			                    iconCls: "add",
			                    handler: function(btn){ 
			                    	
			                    	if(this.xpanlForm.isDirty() && this.widList.getSelectionModel().getSelected()){
				 				
				 			
			                    			Ext.Msg.show({
  									 		title:'Save Widget?',
   											msg: 'Would you like to save your widget?',
  											 buttons: Ext.Msg.YESNOCANCEL,
   									fn: function(res){
   										
   										if(res=='yes'){
   											if(this.xpanlForm.isValid()===true){this.seveWidget();
   											 this.dirty=true;
			                    			 this.wid_store.loadData([{xtype:'New Widget','_created':true}],true);
					                   	 	 this.widList.getSelectionModel().selectLastRow();
   												
   												}
   											 else Ext.Msg.alert('Status', 'Invalid widget properties');  
   											
   										}else if(res=='no'){
   											rec = this.widList.getSelectionModel().getSelected();
   											
   											if(rec.get('_created')===true) this.wid_store.remove(rec);
	   											this.widList.getSelectionModel().clearSelections();
	   											this.resetXpanel();
	   											this.disableWidgetPanel();
	   												this.dirty=true;
			                    			 this.wid_store.loadData([{xtype:'New Widget','_created':true}],true);
					                   	 	 this.widList.getSelectionModel().selectLastRow();
   											
   										}
   									},
   									scope:this,
   									animEl: 'elId',
  									icon: Ext.MessageBox.QUESTION
									});
			                    	}else{
			                    			this.dirty=true;
			                    			 this.wid_store.loadData([{xtype:'New Widget','_created':true}],true);
					                   	 	 this.widList.getSelectionModel().selectLastRow();
			                    		
			                    	}
			                    	
			                    //Se sono in editing il bottone è disabilitato|| 
			             				  	 	
			                    	 },scope:this
			                    
			                  		},{
			                    	tooltip: 'Delete widget',
			                    	iconCls: "delete",
			                    	ref:'/../delW',
			                    	handler: function(btn){ 
			                    			if(rec = this.widList.getSelectionModel().getSelected()){
			                    			Ext.Msg.show({
  											 title:'Delete Widget?',
   											msg: 'Would you like to delete your whidget?',
  										 buttons: Ext.Msg.YESNOCANCEL,
   											
   											fn: function(res){
   										
   										if(res=='yes'){
   											this.dirty=true;
   											rec = this.widList.getSelectionModel().getSelected();
   											if(rec) this.deleteWidget(rec);	
   											this.disableWidgetPanel();
   											this.widList.getSelectionModel().unlock();
   										}
   									},
   									scope:this,
   									animEl: 'elId',
  									icon: Ext.MessageBox.QUESTION
									});}
			                    	
			                    	 },scope:this
			                    
			                  },
			                  {
			                  	text: 'Save',
			                    tooltip: 'Save widget',
			                    iconCls: "accept",
			                    ref:'/../saveW',
			                    handler: function(btn){
			                    			Ext.Msg.show({
  									 		title:'Save Widget?',
   											msg: 'Would you like to save your widget?',
  											 buttons: Ext.Msg.YESNOCANCEL,
   									fn: function(res){
   										if(res=='yes'){
   											if(this.xpanlForm.isValid()===true)this.seveWidget();
   											 else Ext.Msg.alert('Status', 'Invalid widget properties');   
   										}else if(res=='no'){
   											rec = this.widList.getSelectionModel().getSelected();
   											
   											if(rec.get('_created')===true) this.wid_store.remove(rec);
   											
   											this.widList.getSelectionModel().unlock();
   											this.widList.getSelectionModel().clearSelections();
   											this.resetXpanel();
   											this.disableWidgetPanel();
   										}
   									},
   									scope:this,
   									animEl: 'elId',
  									icon: Ext.MessageBox.QUESTION
									});
			                    	 },scope:this
			                    
			                  }
			                  ]
			 		
			 	}
			 	},
				{
                	xtype:'panel',
                	flex:1,
                	frame:true,
                	disabled:false,
       				collapsible: false,
       				border:false,
        			layout:{
						type: 'vbox',
						align: 'stretch'
					},style:{
						padding:'5px'
						
					},
        		    ref:'mainWidget',
     				items:[
     					{	xtype:'compositefield',
	        				ref:'/xpage',
	        				border:false,
     						style:{paddingBottom:'10px'},
     						items:[	{
     							xtype:'label',
     							text:'Page Title',
     							style:{paddingTop:'4px'},
     						},
	        				{
        			   			xtype:'textfield',
        			   			ref:'//pageTitle',
        			   			allowBlank:false,
        			   			width:'100px'
        					},{
     							xtype:'label',
     							hidden:this.pViwHide,
     							text:'Page message',
     							style:{paddingTop:'4px'},
     						},
	        				{
        			   			xtype:'textfield',
        			   			ref:'//pageMsg',
        			   			hidden:this.pViwHide,
        			   			width:'100px'
        					}
        					
        					
        					]},{
	                	xtype:'compositefield',
	        			ref:'/xtypeform',
	        			border:false,
	        			labelWidth: 120,
	     
	        			items:[
     					{
     						xtype:'label',
     						text:'Widget type',
     						style:{paddingTop:'4px'},
     					},
     						{
							xtype:'mxp_mobilextypecombobox', 
							ref:'//xtypeSelector',
							allowedTypes:this.allowedTypes,
						    listeners:{
    						  	select:function(){
  									this.filterType(this.xtypeSelector.getFilter());
    						  		this.addXtypeForm();
    						  	},scope:this
    						  }
    						},
    						{
     						xtype:'label',
     						text:this.sourceLabel,
     						hidden:this.segHidden,
     						style:{paddingTop:'4px'},
     					},
     					    {
     					    	xtype:'combo',
			                    allowBlank: false,
			    				mode: "local",
								queryMode: 'local',
								typeAhead: true,
								hidden:this.segHidden,
			    				forceSelection: true,
			    				triggerAction: "all",
								editable: false,
			                 	displayField: 'name' ,
			                 	valueField: 'name' ,
			                 	lastQuery:'',
		                 		ref:'//fieldSelector',
		                 		store:this.seg_store,
		                 		listeners:{
		                 			select:function(){
		                 			this.xpanlForm.segUpdated();
		                 			},scope:this
		                 		}      
     					    },{
     						xtype:'label',
     						text:this.destLabel,
     						 hidden:this.sopHidden,
     						style:{paddingTop:'4px'},
     					},
     					    {
     					    	xtype:'combo',
			                    allowBlank: false,
			                    hidden:this.sopHidden,
			    				mode: "local",
								queryMode: 'local',
								typeAhead: true,
			    				forceSelection: true,
			    				triggerAction: "all",
								editable: false,
			                 	displayField: 'name' ,
			                 	valueField: 'name' ,
			                 	lastQuery:'', 			                 	
		                 		ref:'//sopSelector',
		                 		store:this.sop_store,
		                 		listeners:{
		                 			select:function(){
		                 			this.xpanlForm.sopUpdated();
		                 		},scope:this
		                 	}
     					    
           					},{
     						xtype:'label',
     						text:'Input Type',
     						style:{paddingTop:'4px'},
     					},
           					{
          
    							xtype:'mxp_mobilexdatatypecombobox',
    							ref:'//xdatatypeSelector',
    						},
    							 { 
    							 xtype: "button",
			                    tooltip: 'Add value',
			                    iconCls: "add",
			                    hidden:true,
			                    handler: function(btn){
			                    	console.log(this.xtypeSelector.getValue()); 
			                    	this.loadXtype(this.objXtype[this.xtypeSelector.getValue()]);
			                    	
			                    	 },scope:this
			                    
			                    }
    						]}
    					
						]
        			}
               ];
               
  
this.on('render',function(){
	this.addXtypeForm();
	this.seg_store.reload();
	this.sop_store.reload();
	this.disableWidgetPanel();
	},this);
//Se cambiano i dati pulisco e ricarico lo store filtrato	
this.seg_store.on('datachanged',function(str){
        	this.fieldSelector.enable();
        	this.fieldSelector.clearValue();
        	var rec= str.getAt(0);
        	if(rec)this.fieldSelector.setValue(rec.data.name);
      		else this.fieldSelector.disable()
        },this);
this.sop_store.on('datachanged',function(str){
        	this.sopSelector.enable();
        	this.sopSelector.clearValue();
        	var rec= str.getAt(0);
        	if(rec)this.sopSelector.setValue(rec.data.name);
      		else this.sopSelector.disable()
        },this);
		mxp.widgets.GcMobileWidgetPanel.superclass.initComponent.call(this, arguments);
},

/**
 *  api method[updateStore]
 * 
 */
updateStore:function(segData,sopData){
			this.seg_store.removeAll();
			this.seg_store.loadData(segData);
			this.sop_store.removeAll()
			this.sop_store.loadData(sopData);
			this.wid_store.removeAll();
			this.cleanAll();
			},
	
/**
 * api: method[loadPage]
 * JSON PAGE
 *
 * */	
loadPage: function(page){
			act=null;
    		this.page=page;
    		if(page.actions)this.actions_store=page.actions;
    		if(this.pageTitle && page.title)this.pageTitle.setValue(page.title);
			if(page.attributes && this.pageMsg)this.pageMsg.setValue(page.attributes.message);
			if(this.wid_store && page.fields )this.wid_store.loadData(page.fields);	
			
			//Carico le action e genero i campi di riferimento. sarebbe tutto da modificare!!
			for(i=0;i<this.actions_store.length;i++){
				act=this.actions_store[i];
				if(act.type=='photo'){
					r= this.wid_store.find('xtype','photo');
					r.text=act.text;}
				else if(act.type=='send') this.wid_store.loadData([{xtype:'actionsend', text:act.text,attributes:{confirmMessage:act.attributes.confirmMessage}}],true);
				else if(act.type=='center') {
					r= this.wid_store.find('xtype','mapViewPoint');
					r.center=true;
					r.centerMsg=act.text;
					}
				else if(act.type=='localize') {
					r= this.wid_store.find('xtype','mapViewPoint');
					r.localize=true;
					r.localizeMsg=act.text;
					}	
				}
			
			//Carico i widegt
			

},	


/**
 * api: method[getPage]
 * return Page obj
 *
 * */
getPage:function(){
	
	var fields=[];
	this.wid_store.each(function(r){		
		if(r.data.xtype!=='actionsend')
		fields.push(r.json);
	});
	this.page={//titolo dalla pagina e campi!!
		title:this.pageTitle.getValue(),
		fields:fields,	
	};
	 if(this.pageMsg.getValue())this.page.attributes={ //Se ho messaggio lo metto nella pagina
					message:this.pageMsg.getValue()
			};
		if(this.actions_store.length>0)	{//attacco azioni della pagina generando id
			this.page.actions=[];
			for(i=0;i<this.actions_store.length;i++){
				act=this.actions_store[i];
				act.id=i+1;
				this.page.actions.push(act);
				
		}};
	
	
	return this.page;
},


/**
 *
 * Laad xtype mobile widget in wiget panel
 * Parameters:
 * xtype label - obj
 * {
 * 	"type":"text",
 *	"xtype":"label",
 *	"value":"${origin.DATA_RILEV}",
 *	"label":"Data Rilevazione"
 *	}
 * 
 * */
loadXtype:function(o){
	//setto
		//Se è uno nuvo creato lo imposto al primo!!
		if(o._created==true){	
			o.xtype=this.xtypeSelector.store.getAt(0).get('value');
		};
		this.setComboVal(this.xtypeSelector,o.xtype,'value');
	
	
	if(this.xpanlForm)this.xpanlForm.loadXtype(o);
	//Setto anche nella lista dei campi se è un campo origine altrimenti lasci al panel
	
	if(o.value && o.value.search(this.clV)>-1)
	this.setComboVal(this.fieldSelector,o.value.replace(this.clV,'$2'),'name');
	if(o.fieldId)
	this.setComboVal(this.sopSelector,o.fieldId,'name');
	if(o.type)
	this.setComboVal(this.xdatatypeSelector,o.type,'value');
},
/**
 *
 * get xtype mobile widget from form panel
 * Return:
 *
 * 
 * */
getXtype:function(){
	
	return this.xpanlForm.getXtype();
	
},




/**
 * api: method[isValid]
 * Validate PAGE 
 * Condition 1) Not in editing 2) Title present 3) 1 Field present 4) 0 or 1 Action present 5) Photo page has only photo widget 
 * 
 * */
isValid:function(){
	if(this.ckPage.disabled) return false; //not in editing
	if(!this.pageTitle.isValid())return false; // Title present
	if(this.wid_store.getCount()==0)return false; // One field
    if(this.wid_store.getCount()==1 && this.actions_store[0] && this.actions_store[0].type=='send')return false; //only one field counld be a sand actino
    return true;
},
	
	//Quando cambia il widget filtro i combo field ed 	xdatatype
filterType:function(filter){
		this.seg_store.filter('localType',filter.field);
		if(this.sop_store)this.sop_store.filter('localType',filter.field);
		this.xdatatypeSelector.getStore().filter('value',filter.xdatatype);
	
	},
//Crea xtype form
 addXtypeForm:function(){
	 var xtype=this.xtypeSelector.getValue();
	 console.log(xtype);
	 	if(xtype){
	 			if(this.xpanlForm)this.xpanlForm.destroy();
	 			
	 		var	f={
			xtype:'mxp_gc_xtype_'+xtype,
			ref:'/xpanlForm',
			border:false,
			 disabledClass:'x-item-disabled',
			style:{marginTop:'30px'}		
				};		 	 
	 		this.mainWidget.add(f);
	 		this.mainWidget.doLayout();
	 			 	}
	 },
//Utilizzata per settare i valori nei combo se esistono in store 	
setComboVal:function(selector,val,sfield){
	
	var store=selector.getStore();
	idx=store.find(sfield,val);
		if(idx > -1){//SE TROVO PER TYPENAME ALLORA SETTO
			 rec=store.getAt(idx);
			 selector.setValue(rec.get(sfield));
			 selector.fireEvent("select",
			 selector, rec, idx);
		}else {
		//mettere messaggio?
			return false;
			}
		
},
/**
 * api method[resetForm]
 * Clean the whole interface
 */
resetForm:function(){
	
	//PER RESETTARE BASTA LANCIARE EVENTO FIERE SU SELECT XTYPE
	this.xtypeSelector.reset();
	rec=this.xtypeSelector.getStore().getAt(0);
	this.xtypeSelector.fireEvent("select",
	this.xtypeSelector, rec, 0);
	this.pageTitle.reset();
	this.pageMsg.reset();
	this.disableWidgetPanel();
},

//clean xpanle interface
resetXpanel:function(){
	
	this.xtypeSelector.reset();
	rec=this.xtypeSelector.getStore().getAt(0);
	this.xtypeSelector.fireEvent("select",
	this.xtypeSelector, rec, idx);
	this.disableWidgetPanel();
	
	
} ,

disableWidgetPanel:function(){
this.xtypeform.disable();
	if(this.xpanlForm)this.xpanlForm.disable();
	//quando esco da editing abilito add
	
	this.delW.disable(true);
	this.saveW.disable(true);
	this.ckPage.enable(true);
},
enableWidgetPanel:function(){
this.xtypeform.enable();
	if(this.xpanlForm)this.xpanlForm.enable();
	//quando vado in editing disabilito add
	
	this.delW.enable(true);
	this.saveW.enable(true);
	this.ckPage.disable(true);
},
//elimina widget ed action
deleteWidget:function(rec){
	if(rec.get('xtype')=='photo'|| rec.get('xtype')=='mapViewPoint' ||rec.get('xtype')=='actionsend' ){
		this.actions_store=[]; //ogni pagina puo avere o azioni photo o map o send(la mappa non sta nel send)
		console.log(this.actions_store);
		}
		this.wid_store.remove(rec);	
	
},
//Aggiorna il widget corrente nella lista
seveWidget:function(){
	this.dirty=true;

	obj=this.getXtype();
	r=this.widList.getSelectionModel().getSelected();
	//Se è una actionsend defi creare action
	r.json=obj;
	
	//Se photo devo creare la actions relativa problema id
	if(obj.xtype==='photo'){
		this.actions_store.push(this.actionPhoto(obj))
	}//ho action send
	else if(obj.xtype==='actionsend' ){
		this.actions_store.push(this.actionSend(obj));
	}else if(obj.xtype==='mapViewPoint'){
		if(obj.localize) this.actions_store.push(this.actionLocalize(obj));
		if(obj.center) this.actions_store.push(this.actionCenter(obj));
		
	}
	r.set('_created',false);
	r.set('xtype',obj.xtype);
	r.set('value',obj.value);
	r.set('fieldId',obj.fieldId);
	r.set('label',obj.label);											
	r.endEdit();
	r.commit();
//	this.wid_store.fireEvent('datachanged',this.wid_store);
	this.widList.getSelectionModel().unlock();
	this.widList.getSelectionModel().clearSelections();

	this.disableWidgetPanel();
	
},
//Crea azione per photo field
actionPhoto:function(o){
	
	a={				
					"text":o.text,
					"name":"photos",
					"type":"photo",
					"iconCls":"ic_camera"
			};
			return a;
	
},
//Crea action send
actionSend:function(o){
    
    o.attributes.url=config.adminUrl+'mvc/geocollect/action/store';
    o.attributes.mediaurl=config.adminUrl+'/mvc/geocollect/data';
   
	a={	
   		
   		"type":'send',
    	"name":'send',
    	"iconCls":"ic_send",
    	"iconCls":o.iconCls,
    	"attributes":o.attributes
  };
	return a;
	
},
//crea action center
actionCenter:function(o){
	
	return{
				
					"text":o.centerMsg,
					"name":"Center",
					"type":"center",
					"iconCls":"ic_center"
			};
	
},
//crea action localize
actionLocalize:function(o){
	return {
			
					"text":o.localizeMsg,
					"name":"Localize",
					"type":"localize",
					"iconCls":"ic_localize"
			};
},
//ripulisce gli store widget e actions e resetta la from
cleanAll:function(){
	this.wid_store.removeAll();
	this.actions_store=null;
	this.actions_store=[];
	this.resetForm();
	this.widList.getSelectionModel().unlock();
	
},

//Limita i possibili widget in base alla pagina!! ritorna il numero di widget disponibili
setXtypeSelectorFilter:function(){
	
		//Prima li rimuovo tutti poi li ricreo
	this.xtypeSelector.store.clearFilter();
	if(this.wid_store.getCount()>1) //Se esiste già un campo non posso creare widget photo solo se è nuovo lo posso creare
		if(!this.wid_store.getAt(0).get('_created')) this.xtypeSelector.store.filter('value',/^((?!photo).)*$/); //Se è campo nuovo può essere anche foto
	//se esiste una action send non posso creare una action sende	o una action photo non posso creare photo o action	                    			
	if(this.actions_store.length>1)
		this.xtypeSelector.store.filter('value',/^((?!actionsend|photo|mapViewPoint).)*$/);
	if(this.actions_store.length==1&& this.actions_store[0].type=='photo') //Se ho foto non posso creare nulla!
		this.xtypeSelector.store.filter('value',/^(!?)$/);
    return this.xtypeSelector.store.getCount();
},

//cerca action se la trova ritorna indice altrimenti ritorna -1
findAction:function(type){
	for(i=0;i<this.actions_store.length;i++){
		if(this.actions_store[i].type==type)return i;
	}
	return -1;
}

});



Ext.reg(mxp.widgets.GcMobileWidgetPanel.prototype.xtype, mxp.widgets.GcMobileWidgetPanel);


