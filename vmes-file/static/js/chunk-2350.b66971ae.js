(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-2350"],{"1W4+":function(e,t,a){},"6xp5":function(e,t,a){"use strict";var n=a("1W4+");a.n(n).a},"F/K7":function(e,t,a){"use strict";a.r(t);a("rGqo");var n=a("uTIz"),s=a("2+ib"),o=a("Vobf"),i=a("sNnr");function l(e,t,a){return t in e?Object.defineProperty(e,t,{value:a,enumerable:!0,configurable:!0,writable:!0}):e[t]=a,e}var c={components:{multilevelTable:s.a,searchBar:n.a},data:function(){var e;return{searchList:[{label:"采购单号",type:"input",ruleType:"string",mapKey:"code",configs:{},placeholder:"请输入采购单号"},{label:"供应商",type:"input",ruleType:"string",mapKey:"supplierName",configs:{},placeholder:"请输入供应商"},{label:"状态",type:"select",ruleType:"number",mapKey:"state",configs:{clearable:!0,name:"",options:[{value:"-1",label:"已取消"},{value:"0",label:"待提交"},{value:"1",label:"待审核"},{value:"2",label:"采购中"},{value:"3",label:"已完成"}]},placeholder:"请选择"},{label:"货品编码",type:"input",ruleType:"string",mapKey:"productCode",configs:{},placeholder:"请输入货品编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"productName",configs:{},placeholder:"请输入货品名称"}],guid:"",searchObj:{},configs:{topBarBtnList:[{name:"审核通过",nameEn:"auditOrder",isShow:!0,icon:"add",method:this.auditOrder}]},tableConfigList:[{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"3",text:"已完成"},info:{state:"-1",text:"已取消"},warning:{state:"1",text:"待审核"},danger:{state:"2",text:"采购中"},default:{state:"0",text:"待提交"}}},{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"退回",nameEn:"reback",editBtns_isShow:!0,icon:"reback",method:this.reback}]}],apiObj:{apiName:"listPagePurchaseOrders",params:{state:"1"}},tempData:{},showIndex:!0,showHeader:!1,showCheckBox:!0,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,expandMode:"none",showExpandBtn:!0,headerStyle:{"background-color":"#E4F3FA"},rowStyle:{"background-color":"#E4F3FA"}},{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:(e={success:{state:"4",text:"已完成"},info:{state:"-1",text:"已取消"},warning:{state:"1",text:"待审核"},danger:{state:"2",text:"采购中"}},l(e,"info",{state:"3",text:"部分签收"}),l(e,"default",{state:"0",text:"待提交"}),e)}],apiObj:{apiName:"listPagePurchaseOrderDetails",params:{}},dynamicValue:{parentId:"self@id"},tempData:{},showIndex:!0,showCheckBox:!0,isSingle:!1,componentId:"twoLevelTable"}],selectList:[],temp:{},tempLable:{},openDialogName:"",showDialog:!1,visible:!1,dialogData:{title:"",temp:null,tempLable:null}}},beforeCreate:function(){},created:function(){this.initButtons()},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{initButtons:function(){var e=this;e.$loading({spinner:"none",text:"智 造 云 管 家"});var t=e.$storage.get("userInfo").roleIds,a=e.$storage.get("menuId");t&&Object(o.initMenuButtons)({menuId:a,roleId:t}).then(function(t){var a=t.buttonList;a&&a.forEach(function(t){e.configs&&(e.configs.queryBarBtnList&&e.configs.queryBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)}),e.configs.topBarBtnList&&e.configs.topBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(console.log(e),e.isShow=!1)}))}),e.$loading().close()}).catch(function(t){console.log(t),e.$loading().close()})},sendGuid:function(e){this.guid=e},searchMap:function(e){console.log(e),this.searchObj=e,this.updateData(e)},databridge:function(e){this.selectList=e},getData:function(){this.$refs.customBaseTable.getData()},pushData:function(e,t){this.$refs.customBaseTable.pushData(e,t)},updateData:function(e){this.$refs.customBaseTable.updateData(e)},deleteData:function(e){this.$refs.customBaseTable.deleteData(e)},reback:function(e,t){var a=this;a.$confirm("此操作将该记录从待审核状态恢复到待提交状态, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(i.rebackPurchaseOrder)(e.id).then(function(e){0===e.code&&(a.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),a.updateData(a.searchObj))}).catch(function(e){console.log(e)})}).catch(function(){a.$message({type:"info",message:"已取消操作"})})},auditOrder:function(){var e=this,t="";e.selectList.forEach(function(e){"1"==e.state&&(t+=""==t?e.id:"','"+e.id)}),""!=t?Object(i.auditPurchaseOrder)(t).then(function(t){0===t.code&&(e.$notify({title:"成功",message:"审核成功",type:"success",duration:2e3}),e.updateData(e.searchObj))}).catch(function(e){console.log(e)}):e.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一条待审核状态的记录！"})},closeDialog:function(e){this.showDialog=!1,"ok"===e.resState&&this.updateData(this.searchObj)},resetTemp:function(){for(var e in this.temp)this.temp[e]=""}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{}},r=(a("6xp5"),a("KHd+")),u=Object(r.a)(c,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"purchasePlan"},[e.searchList.length?a("search-bar",{attrs:{searchList:e.searchList},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),a("el-row",{staticClass:"tableTopBar"},[a("el-col",[a("div",{staticClass:"tableBtns"},[e._l(e.configs.topBarBtnList,function(e,t){return[a("base-button",{directives:[{name:"show",rawName:"v-show",value:e.isShow,expression:"item.isShow"}],attrs:{name:e.name,icon:e.icon,plain:e.plain,state:e.state},on:{myclick:e.method}})]})],2)])],1),e._v(" "),a("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:e.tableHeight+"px"}},[a("el-col",{staticClass:"tableStyle"},[a("div",{staticClass:"baseTable"},[a("el-row",{staticClass:"tableContent"},[a("multilevel-table",{ref:"customBaseTable",attrs:{tableConfigList:e.tableConfigList},on:{databridge:e.databridge}})],1)],1)])],1),e._v(" "),e.showDialog?a(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.visible},on:{"close-dialog":e.closeDialog}}):e._e()],1)},[],!1,null,null,null);u.options.__file="index.vue";t.default=u.exports}}]);