(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-6c2f"],{"+69A":function(e,t,a){"use strict";var i=a("vUli");a.n(i).a},bjTL:function(e,t,a){"use strict";a.r(t);a("rGqo"),a("yt8O"),a("XfO3"),a("9AAn");var i=a("uTIz"),s=a("2+ib"),o=a("OyKK"),n=a("2bT2"),l=a("KKNG"),r=a("imq8"),d={components:{searchBar:i.a,multilevelTable:s.a,dialogAssistProductDetail:n.default,dialogWarehouseOutInfo:l.default,dialogDeliverInfo:r.default,dialogAdd:o.default},data:function(){return{deliverStateNameMap:new Map([["0","待发货"],["1","已发货"],["-1","已取消"]]),outStateNameMap:new Map([["0","未完成"],["1","已完成"],["-1","已取消"]]),searchList:[{label:"发货单号",type:"input",ruleType:"string",mapKey:"deliverCode",configs:{},placeholder:"发货单号"},{label:"订单编号",type:"input",ruleType:"string",mapKey:"orderCode",configs:{},placeholder:"订单编号"},{label:"供应商",type:"input",ruleType:"string",mapKey:"supplier",configs:{},placeholder:"供应商"},{label:"外协件",type:"input",ruleType:"string",mapKey:"assistProductName",configs:{},placeholder:"外协件"},{label:"状态",type:"select",ruleType:"string",mapKey:"deliverDtlState",configs:{clearable:!0,name:"",options:[{value:"0",label:"待发货"},{value:"1",label:"已发货"},{value:"-1",label:"已取消"},{value:"",label:"全部"}]},placeholder:"请选择"}],searchConfig:{hideSearchSwitch:!1},searchObj:{},guid:"",configs:{topBarBtnList:[{name:"发货",nameEn:"dialogAdd",isShow:!0,state:!1,icon:"add",method:this.dialogAdd}]},tableData:[],tableConfigList:[{customColumn:[{columnIndex:"state",width:"80",componentName:"tag",_cellConfig:{success:{state:"1",text:"已发货"},default:{state:"0",text:"待发货"},info1:{state:"1",text:"已发货"},info:{state:"-1",text:"已取消"}}},{columnIndex:"outState",width:"80",componentName:"tag",_cellConfig:{success:{state:"1",text:"已完成"},default:{state:"0",text:"未完成"},info1:{state:"1",text:"已完成"},info:{state:"-1",text:"已取消"}}},{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",width:"200",component:[{name:"取消",nameEn:"cancelByParent",editBtns_isShow:!0},{name:"出库详情",nameEn:"infoOutByParent",editBtns_isShow:!0,rowState:"#self@isShowOut#===1",method:this.infoOutByParent},{name:"发货详情",nameEn:"infoByParent",editBtns_isShow:!0,rowState:"#self@isShowDeliver#==1",method:this.infoDeliverByParent}]}],apiObj:{apiName:"listPageAssistDeliverDetail",params:{fieldCode:"deliverCode,orderCode,supplier,assistProductName,assistProductUnitName,state,outState",isNeedOutId:"true",isNeedInfo:"true",orderStr:"deliverDtl.cdate desc"}},tempData:{},showHeader:!0,showIndex:!1,showCheckBox:!0,isSingle:!0,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,expandMode:"none",showExpandBtn:!0,rowStyle:{"background-color":"#dfe6ec"},buttonStyle:{padding:0,margin:10}},{customColumn:[{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",width:"160",component:[]}],apiObj:{apiName:"listPageAssistDeliverDetailChild",params:{fieldCode:"prodInfo,unitName,count",addColumn:{columnKey:"prodInfo",columnName:"货品"},prodColumnKey:"productCode,productName,productSpec,productProperty",isNeedPage:"false"}},dynamicValue:{deliverDtlId:"self@id"},tempData:{},showIndex:!1,showCheckBox:!1,isSingle:!1,leftFixed:3,rightFixed:0,componentId:"twoLevelTable"}],openDialogName:"",showDialog:!1,visible:!1,dialogData:{title:"",data:null},dialogLoading:!0}},beforeCreate:function(){},created:function(){},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},methods:{updateData:function(e){this.$refs.customBaseTable.updateData(e)},getData:function(){this.$refs.customBaseTable.getData()},searchMap:function(e){this.searchObj=e,this.updateData(this.searchObj)},sendGuid:function(e){this.guid=e},callMethod:function(e){e&&e.methodName&&this[e.methodName](e.params)},databridge:function(e){this.tableData=e,this.configs.topBarBtnList.forEach(function(e){"dialogAdd"==e.nameEn&&(e.state=!1)});var t=!1;if(null!=e&&e.length>0)for(var a=0;a<e.length;a++){if("0"!=e[a].state){t=!0;break}}t&&this.configs.topBarBtnList.forEach(function(e){"dialogAdd"==e.nameEn&&(e.state=!0)})},closeDialog:function(e){this.showDialog=!1,"ok"===e.resState&&this.updateData(this.searchObj)},dialogAdd:function(){if(null==this.tableData||0==this.tableData.length||this.tableData.length>1)this.$message({type:"warning",duration:5e3,showClose:!0,message:"请选择一条发货单数据，只允许单选！"});else{var e=this.tableData[0].state;if("1"!=e&&"-1"!=e){var t=this.tableData[0].outState;"1"==t?(this.dialogData.rowData=JSON.parse(JSON.stringify(this.tableData[0])),this.dialogData.title="发货方式",this.openDialogName="dialogAdd",this.showDialog=!0,this.visible=!0):this.$message({type:"warning",duration:5e3,showClose:!0,message:"该发货单出库状态("+this.outStateNameMap.get(t)+")，不可执行(发货)操作！"})}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"该发货单状态("+this.deliverStateNameMap.get(e)+")，不可执行(发货)操作！"})}},infoOutByParent:function(e){this.dialogData.rowData=JSON.parse(JSON.stringify(e)),this.dialogData.title="出库详情",this.openDialogName="dialogWarehouseOutInfo",this.showDialog=!0,this.visible=!0},infoDeliverByParent:function(e){this.dialogData.rowData=JSON.parse(JSON.stringify(e)),this.dialogData.title="发货详情",this.openDialogName="dialogDeliverInfo",this.showDialog=!0,this.visible=!0}},watch:{}},c=(a("+69A"),a("c6h3"),a("KHd+")),h=Object(c.a)(d,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"assistDeliverList"},[e.searchList.length?a("search-bar",{attrs:{searchList:e.searchList,searchConfig:e.searchConfig},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),a("el-row",[a("el-col",[a("div",[e._l(e.configs.topBarBtnList,function(e,t){return[a("base-button",{directives:[{name:"show",rawName:"v-show",value:e.isShow,expression:"item.isShow"}],attrs:{name:e.name,icon:e.icon,plain:e.plain,state:e.state},on:{myclick:e.method}})]})],2)])],1),e._v(" "),a("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:e.tableHeight+"px"}},[a("el-col",{staticClass:"tableStyle",attrs:{span:24}},[a("div",{staticClass:"baseTable"},[a("el-row",{staticClass:"tableContent"},[a("multilevel-table",{ref:"customBaseTable",attrs:{"data-custom-table-id":"views_assist_assistDeliver_assistDeliverList_index0",tableConfigList:e.tableConfigList},on:{callmethod:e.callMethod,databridge:e.databridge}})],1)],1)])],1),e._v(" "),e.showDialog?a(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.visible},on:{"close-dialog":e.closeDialog}}):e._e()],1)},[],!1,null,null,null);h.options.__file="index.vue";t.default=h.exports},c6h3:function(e,t,a){"use strict";var i=a("uDaS");a.n(i).a},uDaS:function(e,t,a){},vUli:function(e,t,a){}}]);