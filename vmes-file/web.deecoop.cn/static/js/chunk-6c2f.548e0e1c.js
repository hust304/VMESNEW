(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-6c2f"],{"+69A":function(e,t,a){"use strict";var i=a("vUli");a.n(i).a},bjTL:function(e,t,a){"use strict";a.r(t);var i=a("uTIz"),s=a("2+ib"),o=a("OyKK"),l=a("2bT2"),n={components:{searchBar:i.a,multilevelTable:s.a,dialogAssistProductDetail:l.default,dialogAdd:o.default},data:function(){return{searchList:[{label:"订单编号",type:"input",ruleType:"string",mapKey:"sysCode",configs:{},placeholder:"订单编号"},{label:"供应商",type:"input",ruleType:"string",mapKey:"supplierName",configs:{},placeholder:"供应商"},{label:"状态",type:"select",ruleType:"string",mapKey:"state",configs:{clearable:!0,name:"",options:[{value:"0",label:"待提交"},{value:"1",label:"待审核"},{value:"2",label:"待发货"},{value:"3",label:"外协中"},{value:"4",label:"已完成"},{value:"-1",label:"已取消"},{value:"",label:"全部"}]},placeholder:"请选择"}],searchConfig:{hideSearchSwitch:!1},searchObj:{},guid:"",configs:{topBarBtnList:[{name:"发货",nameEn:"dialogAdd",isShow:!0,icon:"add",method:this.dialogAdd}]},tableData:[],tableConfigList:[{customColumn:[],apiObj:{apiName:"listPageAssistDeliverDetail",params:{fieldCode:"deliverCode,orderCode,supplier,assistProductName,assistProductUnitName,stateName,outStateName",isNeedOutId:"true"}},tempData:{},showHeader:!0,showIndex:!1,showCheckBox:!0,isSingle:!0,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,expandMode:"none",showExpandBtn:!0,rowStyle:{"background-color":"#dfe6ec"}},{customColumn:[{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",width:"160",component:[]}],apiObj:{apiName:"listPageAssistDeliverDetailChild",params:{fieldCode:"prodInfo,unitName,count,,",addColumn:{columnKey:"prodInfo",columnName:"货品"},prodColumnKey:"productCode,productName,productSpec,productProperty",isNeedPage:"false"}},dynamicValue:{deliverDtlId:"self@id"},tempData:{},showIndex:!1,showCheckBox:!1,isSingle:!1,leftFixed:3,rightFixed:0,componentId:"twoLevelTable"}],openDialogName:"",showDialog:!1,visible:!1,dialogData:{title:"",data:null},dialogLoading:!0}},beforeCreate:function(){},created:function(){},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},methods:{updateData:function(e){this.$refs.customBaseTable.updateData(e)},getData:function(){this.$refs.customBaseTable.getData()},searchMap:function(e){this.searchObj=e,this.updateData(this.searchObj)},sendGuid:function(e){this.guid=e},callMethod:function(e){e&&e.methodName&&this[e.methodName](e.params)},databridge:function(e){this.tableData=e},closeDialog:function(e){this.showDialog=!1,"ok"===e.resState&&this.updateData(this.searchObj)},dialogAdd:function(){null==this.tableData||0==this.tableData.length||this.tableData.length>1?this.$message({type:"warning",duration:5e3,showClose:!0,message:"请选择一条发货单数据，只允许单选！"}):(this.dialogData.rowData=JSON.parse(JSON.stringify(this.tableData[0])),this.dialogData.title="发货方式",this.openDialogName="dialogAdd",this.showDialog=!0,this.visible=!0)},findAssistProductDetail:function(e){this.dialogData.title="原材料",this.dialogData.parentId=e.assistProductId,this.openDialogName="dialogAssistProductDetail",this.showDialog=!0,this.visible=!0}},watch:{}},d=(a("+69A"),a("c6h3"),a("KHd+")),r=Object(d.a)(n,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"assistDeliverList"},[e.searchList.length?a("search-bar",{attrs:{searchList:e.searchList,searchConfig:e.searchConfig},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),a("el-row",[a("el-col",[a("div",[e._l(e.configs.topBarBtnList,function(e,t){return[a("base-button",{directives:[{name:"show",rawName:"v-show",value:e.isShow,expression:"item.isShow"}],attrs:{name:e.name,icon:e.icon,plain:e.plain,state:e.state},on:{myclick:e.method}})]})],2)])],1),e._v(" "),a("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:e.tableHeight+"px"}},[a("el-col",{staticClass:"tableStyle",attrs:{span:24}},[a("div",{staticClass:"baseTable"},[a("el-row",{staticClass:"tableContent"},[a("multilevel-table",{ref:"customBaseTable",attrs:{"data-custom-table-id":"views_assist_assistDeliver_assistDeliverList_index0",tableConfigList:e.tableConfigList},on:{callmethod:e.callMethod,databridge:e.databridge}})],1)],1)])],1),e._v(" "),e.showDialog?a(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.visible},on:{"close-dialog":e.closeDialog}}):e._e()],1)},[],!1,null,null,null);r.options.__file="index.vue";t.default=r.exports},c6h3:function(e,t,a){"use strict";var i=a("uDaS");a.n(i).a},uDaS:function(e,t,a){},vUli:function(e,t,a){}}]);