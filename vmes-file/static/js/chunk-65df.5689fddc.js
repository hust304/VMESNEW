(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-65df","chunk-32e8"],{"+bMf":function(t,e,a){"use strict";a.d(e,"b",function(){return o}),a.d(e,"a",function(){return n});var i=a("t3Un");function o(t){return Object(i.a)({url:"/sale/saleRetreatAudit/auditPassSaleRetreat",method:"post",data:t})}function n(t){return Object(i.a)({url:"/sale/saleRetreatAudit/auditDisagreeSaleRetreat",method:"post",data:t})}},ZOtG:function(t,e,a){},absB:function(t,e,a){"use strict";var i=a("ZOtG");a.n(i).a},jJ0o:function(t,e,a){"use strict";a.r(e);a("rGqo"),a("yt8O"),a("XfO3"),a("9AAn");var i=a("2+ib"),o=a("uTIz"),n=a("zE1x"),s=a("v0t9"),l=a("+bMf"),r=a("Vobf"),d=(a("z0WU"),{components:{multilevelTable:i.a,searchBar:o.a,dialogAuditDisagree:n.default,dialogInfo:s.default},data:function(){return{retreatStateNameMap:new Map([["0","待提交"],["1","待审核"],["2","待退款"],["3","已完成"],["-1","已取消"]]),searchList:[{label:"退货编号",type:"input",ruleType:"string",mapKey:"sysCode",configs:{},placeholder:"退货编号"},{label:"客户名称",type:"input",ruleType:"string",mapKey:"customerName",configs:{},placeholder:"客户名称"},{label:"退货单状态",type:"select",ruleType:"string",mapKey:"state",configs:{clearable:!0,name:"",options:[{value:"0",label:"待提交"},{value:"1",label:"待审核"},{value:"2",label:"待退款"},{value:"3",label:"已完成"},{value:"-1",label:"已取消"}]},placeholder:"请选择"},{label:"制单日期起",type:"date",ruleType:"date",mapKey:"cdateBegin",configs:{clearable:!0,name:"",type:"date",pickerOptions:{}},placeholder:"请选择"},{label:"制单日期止",type:"date",ruleType:"date",mapKey:"cdateEnd",configs:{clearable:!0,name:"",type:"date",pickerOptions:{}},placeholder:"请选择"}],guid:"",tableConfigList:[{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"3",text:"已完成"},default:{state:"0",text:"待提交"},info1:{state:"1",text:"待审核"},info2:{state:"2",text:"待退款"},info:{state:"-1",text:"已取消"}}},{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"通过",nameEn:"auditPassByParent",editBtns_isShow:!0,icon:"auditPassByParent",method:this.auditPassByParent},{name:"退回",nameEn:"auditDisagreeByParent",editBtns_isShow:!0,icon:"auditDisagreeByParent",method:this.auditDisagreeByParent},{name:"详情",nameEn:"infoByParent",editBtns_isShow:!0,icon:"infoByParent",method:this.infoByParent}]}],apiObj:{apiName:"listPageSaleRetreat",params:{state:"1"}},tempData:{},showHeader:!1,showIndex:!0,showCheckBox:!0,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!0,expandMode:"none",showExpandBtn:!0,headerStyle:{"background-color":"#E4F3FA"},rowStyle:{"background-color":"#E4F3FA"}},{customColumn:[{columnIndex:"state",width:"140",componentName:"tag",_cellConfig:{success:{state:"3",text:"已完成"},default:{state:"0",text:"待提交"},info1:{state:"1",text:"待审核"},info2:{state:"2",text:"待退款"},info:{state:"-1",text:"已取消"}}}],apiObj:{apiName:"listPageSaleRetreatDetail",params:{}},dynamicValue:{parentId:"self@id"},tempData:{},showIndex:!0,showCheckBox:!1,isSingle:!1,componentId:"twoLevelTable"}],searchObj:{},selectList:[],configs:{topBarBtnList:[],tableConfigs:[],showCheckBox:!1},openDialogName:"",showDialog:!1,visible:!1,dialogData:{dialog_width:"",orderDetail_style:"",title:"",data:{},tempLable:null},tableData:[],rowTableList:[]}},beforeCreate:function(){},created:function(){this.initButtons()},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{initButtons:function(){var t=this;t.$loading({spinner:"none",text:"智 造 云 管 家"});var e=t.$storage.get("userInfo").roleIds,a=t.$storage.get("menuId");e&&Object(r.initMenuButtons)({menuId:a,roleId:e}).then(function(e){t.$loading().close();var a=e.buttonList;a&&a.forEach(function(e){t.configs&&(t.configs.queryBarBtnList&&t.configs.queryBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}),t.configs.topBarBtnList&&t.configs.topBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}))})}).catch(function(e){t.$loading().close()})},databridge:function(t){this.temp.dataList=t,this.selectList=t},getData:function(){this.$refs.customBaseTable.getData()},pushData:function(t,e){this.$refs.customBaseTable.pushData(t,e)},updateData:function(t){this.$refs.customBaseTable.updateData(t)},deleteData:function(t){this.$refs.customBaseTable.deleteData(t)},sendGuid:function(t){this.guid=t},searchMap:function(t){this.searchObj=t,this.updateData(this.searchObj)},resetTemp:function(){for(var t in this.temp)this.temp[t]=""},closeDialog:function(t){this.showDialog=!1,"ok"===t.resState&&this.updateData(this.searchObj)},auditPassByParent:function(t,e){var a=this;this.$confirm("此操作将该退货单通过审核, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(l.b)({parentId:t.id,customerId:t.customerId,customerName:t.customerName}).then(function(t){0===t.code&&(a.$notify({title:"成功",message:"审核成功",type:"success",duration:2e3}),a.updateData(a.searchObj))}).catch(function(t){})}).catch(function(){a.$message({type:"info",message:"已取消审核"})})},auditDisagreeByParent:function(t,e){this.dialogData.temp=t,this.dialogData.title="审核退回",this.openDialogName="dialogAuditDisagree",this.showDialog=!0,this.visible=!0},infoByParent:function(t,e){var a=document.body.clientWidth,i=(document.body.clientHeight,.7*a);this.dialogData.dialog_width=i+"px";var o=.666*(.618*i)+"px";this.dialogData.orderDetail_style="height:"+o+";width: 96%;margin-left: 2%;",this.dialogData.data={parentId:t.id},this.dialogData.title="退货单详情",this.openDialogName="dialogInfo",this.showDialog=!0,this.visible=!0}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{}}),c=(a("absB"),a("KHd+")),u=Object(c.a)(d,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"createRetreat"},[t.searchList.length?a("search-bar",{attrs:{searchList:t.searchList},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),a("el-row",{staticClass:"tableTopBar"},[a("el-col",[a("div",{staticClass:"tableBtns"},[t._l(t.configs.topBarBtnList,function(t,e){return[a("base-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"item.isShow"}],attrs:{name:t.name,icon:t.icon,plain:t.plain,state:t.state},on:{myclick:t.method}})]})],2)])],1),t._v(" "),a("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:t.tableHeight+"px"}},[a("el-col",{staticClass:"tableStyle"},[a("div",{staticClass:"baseTable"},[a("el-row",{staticClass:"tableContent"},[a("multilevel-table",{ref:"customBaseTable",attrs:{tableConfigList:t.tableConfigList},on:{databridge:t.databridge}})],1)],1)])],1),t._v(" "),t.showDialog?a(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visible},on:{"close-dialog":t.closeDialog}}):t._e()],1)},[],!1,null,null,null);u.options.__file="index.vue";e.default=u.exports},v0t9:function(t,e,a){"use strict";a.r(e);var i=a("WIyV"),o=(a("91ra"),{components:{customBaseTable:i.a},props:["initData","visible"],data:function(){return{parentId:"",openDialogName:"",dialogLoading:!0,isVisible:!1,inDialog:!0,showDialog:!1,inLinVisible:!1,dialogData:{dialog_width:"",orderDetail_style:"",title:"",temp:null,tempLable:null},tableData:[],rowTableList:[],apiObj:{apiName:"listPageRetreatDetailByEdit",params:{pageNo:1,parentId:"",isRetreatByInfo:"true",fieldCode:"sysOrderCode,deliverCode,productCode,productName,productSpec,orderUnitName,receiveAmount,notRetreatSum,deliverOrderCount,notRetreatCount,orderCount,productPrice,orderSum,remark"}},customColumn:[],mergeTitle:[],mergeColumn:[],mergeRow:[]}},beforeCreate:function(){},created:function(){this.parentId=this.initData.data.parentId,this.apiObj.params.parentId=this.parentId},beforeMount:function(){},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{databridge:function(t){},dialogOpen:function(){},dialogClose:function(t){this.rowTableList=[],this.customerId="",this.deliverDtlIds="",this.$emit("close-dialog",t||{})},closeDialog:function(t){}},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}}}),n=a("KHd+"),s=Object(n.a)(o,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:t.initData.dialog_width},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?a(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[a("el-row",{style:t.initData.orderDetail_style},[a("custom-base-table",{ref:"retreatInfoDialog",attrs:{isSortable:!1,varList:t.tableData,keyValue:!1,showIndex:!0,showTableSet:!1,customColumn:t.customColumn,apiObj:t.apiObj,mergeTitle:t.mergeTitle,mergeColumn:t.mergeColumn,mergeRow:t.mergeRow,componentId:"retreatInfoDialog",useDefaultBtn:!0,showAll:!1},on:{databridge:t.databridge}})],1),t._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,null,null);s.options.__file="dialogInfo.vue";e.default=s.exports},zE1x:function(t,e,a){"use strict";a.r(e);a("rE2o"),a("ioFf");var i=a("+bMf");function o(t){return(o="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var n={name:"dialog-edit",props:["initData","visible"],data:function(){return{retreatId:"",dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{},rules:{remark:[{required:!0,message:"请填写退回原因！",trigger:"change"}]}}},created:function(){this.retreatId=this.initData.temp.id},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=o(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]}},methods:{dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},save:function(){var t=this;this.$refs.submitForm.validate(function(e){if(e){t.dialogLoading=!0;var a=t.$storage.get("userInfo").userName;Object(i.a)({parentId:t.retreatId,remark:t.temp.remark,userName:a}).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"退回成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){t.dialogLoading=!1})}})}}},s=a("KHd+"),l=Object(s.a)(n,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"编辑",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"400px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[a("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[a("el-form",{ref:"submitForm",staticStyle:{width:"90%",margin:"30px auto"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[a("el-form-item",{attrs:{label:"退回原因:",prop:"remark"}},[a("el-input",{staticStyle:{width:"240px"},attrs:{type:"textarea",rows:2},model:{value:t.temp.remark,callback:function(e){t.$set(t.temp,"remark",e)},expression:"temp.remark"}})],1)],1),t._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),a("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)])},[],!1,null,null,null);l.options.__file="dialogAuditDisagree.vue";e.default=l.exports}}]);