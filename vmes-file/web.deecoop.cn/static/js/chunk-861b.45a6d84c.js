(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-861b"],{DFVd:function(t,e,a){},HOVO:function(t,e,a){"use strict";var i=a("DFVd");a.n(i).a},gOQQ:function(t,e,a){},idm0:function(t,e,a){"use strict";a.r(e);a("rGqo");var i=a("2+ib"),n=a("uTIz"),s=a("qzdK"),o=a("JgNL"),l=a("ohqc"),r=a("Vobf"),c={components:{multilevelTable:i.a,searchBar:n.a,dialogAdd:s.default,dialogCancel:o.default,dialogRepairTask:l.default},data:function(){return{searchList:[{label:"设备编码",type:"input",ruleType:"string",mapKey:"equipmentCode",configs:{},placeholder:"设备编码"},{label:"设备名称",type:"input",ruleType:"string",mapKey:"equipmentName",configs:{},placeholder:"设备名称"},{label:"状态",type:"select",ruleType:"string",mapKey:"equipmentState",configs:{clearable:!0,name:"",options:[{value:"1",label:"故障"},{value:"2",label:"维修中"},{value:"3",label:"已完成"}]},placeholder:"请选择"}],guid:"",tableConfigList:[{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"3",text:"已完成"},info:{state:"2",text:"维修中"},default:{state:"1",text:"故障"}}},{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"取消报修",nameEn:"repairCancel",editBtns_isShow:!0,rowState:"#self@equipmentState#===1",method:this.repairCancel},{name:"查看详情",nameEn:"repairTask",editBtns_isShow:!0,method:this.repairTask}]}],apiObj:{apiName:"listPageEquipmentRepair",params:{fieldCode:"sysCode,equipmentCode,equipmentName,warnDateTimeStr,faultDescribe,isStopName,beginTimeStr,endTimeStr,equipmentStateName",dataType:this.$storage.get("dataType"),orderStr:"repair.cdate desc"}},tempData:{},showHeader:!0,showIndex:!0,showCheckBox:!1,showTableSet:!1,showAll:!1,componentId:"oneLevelTable"}],searchObj:{},selectList:[],configs:{topBarBtnList:[{name:"新增",nameEn:"add",isShow:!0,icon:"add",method:this.dialogAdd}],tableConfigs:[]},temp:{},openDialogName:"",showDialog:!1,visible:!1,dialogData:{dialog_width:"",table_style:"",repairTaskId:"",repairId:"",title:""}}},beforeCreate:function(){},created:function(){this.initButtons()},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{initButtons:function(){var t=this,e=t.$storage.get("userInfo").roleIds,a=t.$storage.get("menuId");e&&(t.$loading({spinner:"preloader",text:""}),Object(r.initMenuButtons)({menuId:a,roleId:e}).then(function(e){t.$loading().close();var a=e.buttonList;a&&a.forEach(function(e){t.configs&&(t.configs.queryBarBtnList&&t.configs.queryBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}),t.configs.topBarBtnList&&t.configs.topBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)})),t.tableConfigList&&t.tableConfigList.forEach(function(t){t.customColumn&&t.customColumn.forEach(function(t){"last"==t.columnIndex&&t.component&&t.component.forEach(function(t){t.nameEn==e.nameEn&&(t.rowState="1==2")})})})})}).catch(function(e){t.$loading().close()}))},databridge:function(t){this.selectList=t},getData:function(){this.$refs.customBaseTable.getData()},pushData:function(t,e){this.$refs.customBaseTable.pushData(t,e)},updateData:function(t){this.$refs.customBaseTable.updateData(t)},deleteData:function(t){this.$refs.customBaseTable.deleteData(t)},callMethod:function(t){t&&t.methodName&&this[t.methodName](t.params)},sendGuid:function(t){this.guid=t},searchMap:function(t){this.searchObj=t,this.updateData(this.searchObj)},resetTemp:function(){for(var t in this.temp)this.temp[t]=""},closeDialog:function(t){this.showDialog=!1,"ok"===t.resState&&this.updateData(this.searchObj)},dialogAdd:function(){this.resetTemp(),this.dialogData.temp=this.temp,this.dialogData.title="新增设备维修单",this.openDialogName="dialogAdd",this.showDialog=!0,this.visible=!0},repairCancel:function(t,e){this.dialogData.repairId=t.id,this.dialogData.repairTaskId=t.repairTaskId,this.dialogData.title="取消维修单",this.openDialogName="dialogCancel",this.showDialog=!0,this.visible=!0},repairTask:function(t,e){var a=.6*document.body.clientWidth;this.dialogData.dialog_width=a+"px";var i=.75*(.618*a)+"px";this.dialogData.table_style="height:"+i+";width: 96%;margin-left: 2%;",this.dialogData.repairId=t.id,this.openDialogName="dialogRepairTask",this.dialogData.title="查看详情",this.showDialog=!0,this.visible=!0}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{}},d=(a("xQhl"),a("HOVO"),a("KHd+")),h=Object(d.a)(c,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"repairManage"},[t.searchList.length?a("search-bar",{attrs:{searchList:t.searchList},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),a("el-row",{staticClass:"tableTopBar"},[a("el-col",[a("div",{staticClass:"tableBtns"},[t._l(t.configs.topBarBtnList,function(t,e){return[a("base-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"item.isShow"}],attrs:{name:t.name,icon:t.icon,plain:t.plain,state:t.state},on:{myclick:t.method}})]})],2)])],1),t._v(" "),a("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:t.tableHeight+"px"}},[a("el-col",{staticClass:"tableStyle"},[a("div",{staticClass:"baseTable"},[a("el-row",{staticClass:"tableContent"},[a("multilevel-table",{ref:"customBaseTable",attrs:{"data-custom-table-id":"views_equipment_equipmentRepair_repair_index0",tableConfigList:t.tableConfigList},on:{callmethod:t.callMethod,databridge:t.databridge}})],1)],1)])],1),t._v(" "),t.showDialog?a(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visible},on:{"close-dialog":t.closeDialog}}):t._e()],1)},[],!1,null,null,null);h.options.__file="index.vue";e.default=h.exports},xQhl:function(t,e,a){"use strict";var i=a("gOQQ");a.n(i).a}}]);