(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-17b6","r/Cm"],{Ie5K:function(t,e,i){"use strict";var a=i("yETL");i.n(a).a},TBNO:function(t,e,i){"use strict";i.r(e);i("rGqo");var a=i("uTIz"),n=i("2+ib"),o=i("r/Cm"),s=i("Vobf"),l=i("sNnr"),r={components:{dialogAddReceipt:o.default,multilevelTable:n.a,searchBar:a.a},data:function(){return{searchList:[{label:"采购单号",type:"input",ruleType:"string",mapKey:"code",configs:{},placeholder:"请输入采购单号"},{label:"供应商",type:"input",ruleType:"string",mapKey:"supplierName",configs:{},placeholder:"请输入供应商"},{label:"状态",type:"select",ruleType:"number",mapKey:"state",configs:{clearable:!0,name:"",options:[{value:"-1",label:"已取消"},{value:"0",label:"待提交"},{value:"1",label:"待审核"},{value:"2",label:"采购中"},{value:"3",label:"已完成"}]},placeholder:"请选择"},{label:"货品编码",type:"input",ruleType:"string",mapKey:"productCode",configs:{},placeholder:"请输入货品编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"productName",configs:{},placeholder:"请输入货品名称"}],guid:"",searchObj:{},configs:{topBarBtnList:[]},tableConfigList:[{customColumn:[{columnIndex:"code",width:"200"},{columnIndex:"supplierName",width:"160"},{columnIndex:"applyName",width:"140"},{columnIndex:"deptName",width:"160"},{columnIndex:"amount"},{columnIndex:"receiptAmount"},{columnIndex:"remark"},{columnIndex:"receiptState",width:"140",componentName:"tag",_cellConfig:{success:{state:"2",text:"已收票"},info:{state:"0",text:"未收票"},warning:{state:"1",text:"部分收票"}}},{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"3",text:"已完成"},info:{state:"-1",text:"已取消"},warning:{state:"1",text:"待审核"},danger:{state:"2",text:"采购中"},default:{state:"0",text:"待提交"}}},{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"收票",nameEn:"addReceipt",editBtns_isShow:!0,icon:"addReceipt",method:this.addReceipt},{name:"附件管理",nameEn:"reback",editBtns_isShow:!0,icon:"reback",method:this.reback}]}],apiObj:{apiName:"listPagePurchaseOrders",params:{fieldCode:"code,supplierName,applyName,deptName,remark,amount,receiptAmount,receiptState,state",state:"1",orderStr:" purchaseOrder.code desc"}},tempData:{},showIndex:!0,showHeader:!1,showCheckBox:!1,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,expandMode:"none",showExpandBtn:!0,headerStyle:{"background-color":"#E4F3FA"},rowStyle:{"background-color":"#E4F3FA"}},{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"4",text:"已完成"},info:{state:"-1",text:"已取消"},warning:{state:"1",text:"待审核"},danger:{state:"2",text:"采购中"},info1:{state:"3",text:"部分签收"},default:{state:"0",text:"待提交"}}}],apiObj:{apiName:"listPagePurchaseOrderDetails",params:{isNeedPage:"false"}},dynamicValue:{parentId:"self@id"},tempData:{},showIndex:!0,showCheckBox:!1,isSingle:!1,componentId:"twoLevelTable"}],selectList:[],temp:{},tempLable:{},openDialogName:"",showDialog:!1,visible:!1,dialogData:{title:"",temp:null,tempLable:null}}},beforeCreate:function(){},created:function(){this.initButtons()},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{initButtons:function(){var t=this,e=t.$storage.get("userInfo").roleIds,i=t.$storage.get("menuId");e&&(t.$loading({spinner:"none",text:"智 造 云 管 家"}),Object(s.initMenuButtons)({menuId:i,roleId:e}).then(function(e){t.$loading().close();var i=e.buttonList;i&&i.forEach(function(e){t.configs&&(t.configs.queryBarBtnList&&t.configs.queryBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}),t.configs.topBarBtnList&&t.configs.topBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(console.log(t),t.isShow=!1)}))})}).catch(function(e){console.log(e),t.$loading().close()}))},sendGuid:function(t){this.guid=t},searchMap:function(t){console.log(t),this.searchObj=t,this.updateData(t)},databridge:function(t){this.selectList=t,this.configs.topBarBtnList.forEach(function(t){"auditOrder"==t.nameEn&&(t.state=!1)});var e=!1;if(null!=t&&t.length>0)for(var i=0;i<t.length;i++){if("1"!=t[i].state){e=!0;break}}e&&this.configs.topBarBtnList.forEach(function(t){"auditOrder"==t.nameEn&&(t.state=!0)})},getData:function(){this.$refs.customBaseTable.getData()},pushData:function(t,e){this.$refs.customBaseTable.pushData(t,e)},updateData:function(t){this.selectList=[],this.$refs.customBaseTable.updateData(t)},deleteData:function(t){this.$refs.customBaseTable.deleteData(t)},callMethod:function(t){t&&t.methodName&&this[t.methodName](t.params)},addReceipt:function(t,e){this.dialogData.temp=t,this.dialogData.title="收票金额",this.openDialogName="dialogAddReceipt",this.showDialog=!0,this.visible=!0},auditOrder:function(){var t=this,e="";t.selectList.forEach(function(t){"1"==t.state&&(e+=""==e?t.id:"','"+t.id)}),""!=e?t.$confirm("是否审核通过?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(l.auditPurchaseOrder)(e).then(function(e){0===e.code&&(t.$notify({title:"成功",message:"审核成功",type:"success",duration:2e3}),t.updateData(t.searchObj))}).catch(function(t){console.log(t)})}):t.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一条待审核状态的记录！"})},closeDialog:function(t){this.showDialog=!1,"ok"===t.resState&&this.updateData(this.searchObj)},resetTemp:function(){for(var t in this.temp)this.temp[t]=""}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{}},c=(i("Ie5K"),i("KHd+")),d=Object(c.a)(r,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"purchasePlan"},[t.searchList.length?i("search-bar",{attrs:{searchList:t.searchList},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),i("el-row",{staticClass:"tableTopBar"},[i("el-col",[i("div",{staticClass:"tableBtns"},[t._l(t.configs.topBarBtnList,function(t,e){return[i("base-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"item.isShow"}],attrs:{name:t.name,icon:t.icon,plain:t.plain,state:t.state},on:{myclick:t.method}})]})],2)])],1),t._v(" "),i("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:t.tableHeight+"px"}},[i("el-col",{staticClass:"tableStyle"},[i("div",{staticClass:"baseTable"},[i("el-row",{staticClass:"tableContent"},[i("multilevel-table",{ref:"customBaseTable",attrs:{tableConfigList:t.tableConfigList},on:{callmethod:t.callMethod,databridge:t.databridge}})],1)],1)])],1),t._v(" "),t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visible},on:{"close-dialog":t.closeDialog}}):t._e()],1)},[],!1,null,null,null);d.options.__file="index.vue";e.default=d.exports},"r/Cm":function(t,e,i){"use strict";i.r(e);i("rE2o"),i("ioFf");var a=i("sNnr");function n(t){return(n="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var o={name:"dialog-edit",props:["initData","visible"],data:function(){return{orderId:"",dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{},rules:{receiptAmount:[{required:!0,message:"请填写退回原因！",trigger:"change"}]}}},created:function(){this.orderId=this.initData.temp.id},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=n(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]}},methods:{dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},save:function(){var t=this;this.$refs.submitForm.validate(function(e){e&&(t.dialogLoading=!0,Object(a.addReceipt)({id:t.initData.temp.id,receiptAmount:t.temp.receiptAmount}).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"退回成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){t.dialogLoading=!1}))})}}},s=i("KHd+"),l=Object(s.a)(o,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"编辑",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"400px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{width:"90%",margin:"30px auto"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[i("el-form-item",{attrs:{label:"收票金额:",prop:"receiptAmount"}},[i("el-input",{staticStyle:{width:"240px"},model:{value:t.temp.receiptAmount,callback:function(e){t.$set(t.temp,"receiptAmount",t._n(e))},expression:"temp.receiptAmount"}})],1)],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)])},[],!1,null,null,null);l.options.__file="dialogAddReceipt.vue";e.default=l.exports},yETL:function(t,e,i){}}]);