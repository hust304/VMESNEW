(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-3f39"],{"9s2i":function(e,t,a){},Plil:function(e,t,a){"use strict";var i=a("9s2i");a.n(i).a},QPJl:function(e,t,a){"use strict";a.r(t);var i=a("uTIz"),s=a("2+ib"),o=a("W3AZ"),l=a("2bT2"),n={components:{searchBar:i.a,multilevelTable:s.a,dialogAssistProductDetail:l.default,dialogAdd:o.default},data:function(){return{searchList:[{label:"订单编号",type:"input",ruleType:"string",mapKey:"sysCode",configs:{},placeholder:"订单编号"},{label:"供应商",type:"input",ruleType:"string",mapKey:"supplierName",configs:{},placeholder:"供应商"},{label:"状态",type:"select",ruleType:"string",mapKey:"state",configs:{clearable:!0,name:"",options:[{value:"0",label:"待提交"},{value:"1",label:"待审核"},{value:"2",label:"待发货"},{value:"3",label:"外协中"},{value:"4",label:"已完成"},{value:"-1",label:"已取消"},{value:"",label:"全部"}]},placeholder:"请选择"}],searchConfig:{hideSearchSwitch:!1},searchObj:{},guid:"",tableData:[],tableConfigList:[{customColumn:[{columnIndex:"state",width:"80",componentName:"tag",_cellConfig:{success:{state:"4",text:"已完成"},default:{state:"0",text:"待提交"},info1:{state:"1",text:"待审核"},info2:{state:"2",text:"待发货"},info3:{state:"3",text:"外协中"},info4:{state:"4",text:"已完成"},info:{state:"-1",text:"已取消"}}}],apiObj:{apiName:"listPageAssistOrder",params:{fieldCode:"sysCode,supplierName,makeUserName,orderDate,amount,state",state:"2",orderStr:"assistOrder.cdate desc"}},tempData:{},showHeader:!0,showIndex:!1,showCheckBox:!1,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,expandMode:"none",showExpandBtn:!0,rowStyle:{"background-color":"#dfe6ec"}},{customColumn:[{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",width:"160",component:[{name:"生成发货",nameEn:"createDeliverByDetail",editBtns_isShow:!0,method:this.createDeliverByDetail},{name:"原材料",nameEn:"findAssistProductDetail",editBtns_isShow:!0,method:this.findAssistProductDetail}]}],apiObj:{apiName:"listPageAssistOrderDetail",params:{fieldCode:"assistProductName,craftName,orderUnitName,orderCount,lossRatio,price,expectDate,planCode,stateName",isNeedPage:"false"}},dynamicValue:{parentId:"self@id"},tempData:{},showIndex:!1,showCheckBox:!1,isSingle:!1,componentId:"twoLevelTable",buttonStyle:{padding:0,margin:10}}],openDialogName:"",showDialog:!1,visible:!1,dialogData:{title:"",data:null},dialogLoading:!0}},beforeCreate:function(){},created:function(){},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},methods:{updateData:function(e){this.$refs.customBaseTable.updateData(e)},getData:function(){this.$refs.customBaseTable.getData()},searchMap:function(e){this.searchObj=e,this.updateData(this.searchObj)},sendGuid:function(e){this.guid=e},callMethod:function(e){e&&e.methodName&&this[e.methodName](e.params)},databridge:function(e){this.tableData=e},closeDialog:function(e){this.showDialog=!1,"ok"===e.resState&&this.updateData(this.searchObj)},createDeliverByDetail:function(e){this.dialogData.rowData=JSON.parse(JSON.stringify(e)),this.dialogData.title="生成发货单",this.openDialogName="dialogAdd",this.showDialog=!0,this.visible=!0},findAssistProductDetail:function(e){this.dialogData.title="原材料",this.dialogData.parentId=e.assistProductId,this.openDialogName="dialogAssistProductDetail",this.showDialog=!0,this.visible=!0}},watch:{}},r=(a("clvR"),a("Plil"),a("KHd+")),d=Object(r.a)(n,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"createAssistDeliver"},[e.searchList.length?a("search-bar",{attrs:{searchList:e.searchList,searchConfig:e.searchConfig},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),a("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:e.tableHeight+"px"}},[a("el-col",{staticClass:"tableStyle",attrs:{span:24}},[a("div",{staticClass:"baseTable"},[a("el-row",{staticClass:"tableContent"},[a("multilevel-table",{ref:"customBaseTable",attrs:{"data-custom-table-id":"views_assist_assistDeliver_createAssistDeliver_index0",tableConfigList:e.tableConfigList},on:{callmethod:e.callMethod,databridge:e.databridge}})],1)],1)])],1),e._v(" "),e.showDialog?a(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.visible},on:{"close-dialog":e.closeDialog}}):e._e()],1)},[],!1,null,null,null);d.options.__file="index.vue";t.default=d.exports},clvR:function(e,t,a){"use strict";var i=a("vJ49");a.n(i).a},vJ49:function(e,t,a){}}]);