(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-431d","KC3E"],{KC3E:function(e,t,a){"use strict";a.r(t);a("rGqo"),a("Oyvg");var o=a("WIyV"),i=a("91ra"),r={components:{customBaseTable:o.a,dialogAdd:s},props:["initData","visible"],data:function(){var e=this;return{customerId:"",deliverDtlIds:"",formData:{cuserName:"",customerName:"",type:"",typeName:""},rules:{typeName:[{required:!0,trigger:"change",validator:function(t,a,o){e.typeData.defaultSelected.length<=0?o(new Error("请选择退货类型")):o()}}]},openDialogName:"",dialogLoading:!0,isVisible:!1,inDialog:!0,showDialog:!1,inLinVisible:!1,dialogData:{dialog_width:"",orderDetail_style:"",title:"",temp:null,tempLable:null},typeData:{data:{selectUrl:"/system/dictionary/getDictionarys",selectParm:{dictionaryKey:"retreatType",isglobal:"1"}},defaultSelected:[]},tableData:[],rowTableList:[],apiObj:{apiName:"listPageDeliverDetailByRetreat",params:{pageNo:1,deliverDtlIds:"",state:"1",fieldCode:"sysOrderCode,deliverCode,productCode,productName,productSpec,orderUnitName,orderCount,notRetreatCount,retreatOrderCount,productPrice,retreatOrderSum,retreatRemark"}},customColumn:[{columnIndex:"retreatOrderCount",componentName:"input",_cellConfig:{rules:[{regexp:"^[0-9]+\\.{0,1}[0-9]{0,2}$"},{lessThan:["self@notRetreatCount",!0]}],message:["请输入大于零的正整数或(1,2)位小数！","必须小于等于可退货数量！","必须大于零！"]}},{columnIndex:"retreatOrderSum",componentName:"input",_cellConfig:{compute:"self@retreatOrderCount(*)self@productPrice",editable:!1}},{columnIndex:"retreatRemark",componentName:"input",_cellConfig:{}}],mergeTitle:[],mergeColumn:[],mergeRow:[]}},beforeCreate:function(){},created:function(){this.customerId=this.initData.customerId,this.deliverDtlIds=this.initData.deliverDtlIds,this.apiObj.params.deliverDtlIds=this.deliverDtlIds;var e=this.$storage.get("userInfo");this.formData.cuserName=e.userName,this.formData.customerName=this.initData.customerName},beforeMount:function(){},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{databridge:function(e){this.rowTableList=[],Array.isArray(e)&&(this.rowTableList=e)},isNumberByValue:function(e){return null!=e&&0!=e.trim().length&&new RegExp("^[0-9]+([.]{1}[0-9]{1,2})?$").test(e.trim())},checkColumn:function(e){for(var t="",a=0;a<e.length;a++){var o=e[a],i=o.retreatOrderCount;i-o.notRetreatCount>0&&(t=t+"第 "+(a+1)+" 行: 本次退货数量("+i+") 输入错误，本次退货数量不可大于可退货数量！")}return t},typeSelect:function(e){e[0]?(this.formData.type=e[0],this.typeData.defaultSelected=[e[0]]):(this.formData.type=[],this.typeData.defaultSelected=[])},save:function(){var e=this;this.$refs.submitForm.validate(function(t){t&&(e.$refs.retreatAddDialog.getData(),null!=e.rowTableList&&e.rowTableList.length>0&&e.saveSaleRetreat(e.rowTableList))})},saveSaleRetreat:function(e){var t=this;if(null!=e&&0!=e.length){var a=this.checkColumn(e);if(null!=a&&a.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:a});else{var o=[];e.forEach(function(e){var t={deliverDetailId:e.id,orderDetailId:e.orderDetaiId,productId:e.productId,orderSum:e.retreatOrderSum,orderUnit:e.orderUnit,orderCount:e.retreatOrderCount,productUnit:e.productUnit,remark:e.retreatRemark,sysOrderCode:e.sysOrderCode,orderId:e.orderId,receiveAmount:e.receiveAmount,notRetreatSum:e.notRetreatSum,n2pFormula:e.n2pFormula,p2nFormula:e.p2nFormula};o.push(t)});var r="";null!=o&&o.length>0&&(r=JSON.stringify(o)),null!=r&&0!=r?this.$confirm("添加退货单后，是否将该退货单提交？","提示",{distinguishCancelAndClose:!0,confirmButtonText:"是",cancelButtonText:"否",type:"warning"}).then(function(){Object(i.addSaleRetreat)({type:t.formData.type,remark:t.formData.remark,customerId:t.customerId,dtlJsonStr:r,isAutoCommit:"true"}).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){})}).catch(function(e){"cancel"==e&&Object(i.addSaleRetreat)({type:t.formData.type,remark:t.formData.remark,customerId:t.customerId,dtlJsonStr:r,isAutoCommit:"false"}).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){})}):this.$message({type:"warning",duration:5e3,showClose:!0,message:"暂无发货单明细！"})}}},dialogOpen:function(){},dialogClose:function(e){this.rowTableList=[],this.customerId="",this.deliverDtlIds="",this.$emit("close-dialog",e||{})},closeDialog:function(e){}},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}}},l=a("KHd+"),n=Object(l.a)(r,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:e.initData.dialog_width},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?a(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}],staticStyle:{"padding-top":"10px"}},[a("el-form",{ref:"submitForm",staticStyle:{"padding-top":"10px","padding-right":"20px","padding-left":"20px"},attrs:{rules:e.rules,model:e.formData,"label-position":"right","label-width":"90px"}},[a("el-row",[a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"退货类型:",prop:"typeName"}},[a("base-input-select",{attrs:{data:e.typeData.data},on:{callback:e.typeSelect},model:{value:e.typeData.defaultSelected,callback:function(t){e.$set(e.typeData,"defaultSelected",t)},expression:"typeData.defaultSelected"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"客户名称:",prop:"customerName"}},[a("el-input",{attrs:{readonly:!0},model:{value:e.formData.customerName,callback:function(t){e.$set(e.formData,"customerName",t)},expression:"formData.customerName"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"制单人:",prop:"makeName"}},[a("el-input",{attrs:{readonly:!0},model:{value:e.formData.cuserName,callback:function(t){e.$set(e.formData,"cuserName",t)},expression:"formData.cuserName"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"备注:",prop:"remark"}},[a("el-input",{model:{value:e.formData.remark,callback:function(t){e.$set(e.formData,"remark",t)},expression:"formData.remark"}})],1)],1)],1),e._v(" "),a("el-row",{style:e.initData.orderDetail_style},[a("custom-base-table",{ref:"retreatAddDialog",attrs:{isSortable:!1,varList:e.tableData,keyValue:!1,showIndex:!0,showTableSet:!1,customColumn:e.customColumn,apiObj:e.apiObj,mergeTitle:e.mergeTitle,mergeColumn:e.mergeColumn,mergeRow:e.mergeRow,componentId:"retreatAddDialog",useDefaultBtn:!0,showAll:!1},on:{databridge:e.databridge}})],1)],1),e._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),a("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);n.options.__file="dialogAdd.vue";var s=t.default=n.exports},n4yU:function(e,t,a){"use strict";a.r(t);a("rGqo"),a("Oyvg");var o=a("WIyV"),i=a("KC3E"),r=a("91ra"),l={components:{customBaseTable:o.a,dialogAdd:i.default},props:["initData","visible"],data:function(){var e=this;return{parentId:"",formData:{cuserName:"",customerName:"",type:"",typeName:""},rules:{typeName:[{required:!0,trigger:"change",validator:function(t,a,o){e.typeData.defaultSelected.length<=0?o(new Error("请选择退货类型")):o()}}]},openDialogName:"",dialogLoading:!0,isVisible:!1,inDialog:!0,showDialog:!1,inLinVisible:!1,dialogData:{dialog_width:"",orderDetail_style:"",title:"",temp:null,tempLable:null},typeData:{data:{selectUrl:"/system/dictionary/getDictionarys",selectParm:{dictionaryKey:"retreatType",isglobal:"1"}},defaultSelected:[]},tableData:[],rowTableList:[],apiObj:{apiName:"listPageRetreatDetailByEdit",params:{pageNo:1,parentId:"",isRetreatByEdit:"true",fieldCode:"sysOrderCode,deliverCode,productCode,productName,productSpec,orderUnitName,notRetreatCount,orderCount,productPrice,orderSum,remark"}},customColumn:[{columnIndex:"orderCount",componentName:"input",_cellConfig:{rules:[{regexp:"^[0-9]+\\.{0,1}[0-9]{0,2}$"}],message:["请输入大于零的正整数或(1,2)位小数！"]}},{columnIndex:"orderSum",componentName:"input",_cellConfig:{compute:"self@orderCount(*)self@productPrice",editable:!1}},{columnIndex:"remark",componentName:"input",_cellConfig:{}}],mergeTitle:[],mergeColumn:[],mergeRow:[]}},beforeCreate:function(){},created:function(){this.parentId=this.initData.data.parentId,this.apiObj.params.parentId=this.parentId,this.formData.remark=this.initData.remark,this.formData.type=this.initData.type,this.typeData.defaultSelected[0]=this.initData.type;var e=this.$storage.get("userInfo");this.formData.cuserName=e.userName,this.formData.customerName=this.initData.customerName},beforeMount:function(){},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{databridge:function(e){this.rowTableList=[],Array.isArray(e)&&(this.rowTableList=e)},isNumberByValue:function(e){return null!=e&&0!=e.trim().length&&new RegExp("^[0-9]+([.]{1}[0-9]{1,2})?$").test(e.trim())},checkColumn:function(e){for(var t="",a=0;a<e.length;a++){var o=e[a],i=o.orderCount;i-o.notRetreatCount>0&&(t=t+"第 "+(a+1)+" 行: 退货数量("+i+") 输入错误，退货数量不可大于可退货数量！")}return t},typeSelect:function(e){e[0]?(this.formData.type=e[0],this.typeData.defaultSelected=[e[0]]):(this.formData.type=[],this.typeData.defaultSelected=[])},save:function(){var e=this;this.$refs.submitForm.validate(function(t){t&&(e.$refs.retreatEditDialog.getData(),null!=e.rowTableList&&e.rowTableList.length>0&&e.saveSaleRetreat(e.rowTableList))})},saveSaleRetreat:function(e){var t=this;if(null!=e&&0!=e.length){var a=this.checkColumn(e);if(null!=a&&a.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:a});else{var o=[];e.forEach(function(e){var t={deliverDetailId:e.deliverDetailId,orderDetailId:e.orderDetailId,productId:e.productId,orderSum:e.orderSum,orderUnit:e.orderUnit,orderCount:e.orderCount,productUnit:e.productUnit,remark:e.remark,sysOrderCode:e.sysOrderCode,orderId:e.orderId,receiveAmount:e.receiveAmount,notRetreatSum:e.notRetreatSum,n2pFormula:e.n2pFormula,p2nFormula:e.p2nFormula};o.push(t)});var i="";null!=o&&o.length>0&&(i=JSON.stringify(o)),null!=i&&0!=i?this.$confirm("修改退货单后，是否将该退货单提交？","提示",{distinguishCancelAndClose:!0,confirmButtonText:"是",cancelButtonText:"否",type:"warning"}).then(function(){Object(r.updateSaleRetreat)({type:t.formData.type,remark:t.formData.remark,parentId:t.parentId,dtlJsonStr:i,isAutoCommit:"true"}).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){t.dialogLoading=!1})}).catch(function(e){"cancel"==e&&Object(r.updateSaleRetreat)({type:t.formData.type,remark:t.formData.remark,parentId:t.parentId,dtlJsonStr:i,isAutoCommit:"false"}).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){t.dialogLoading=!1})}):this.$message({type:"warning",duration:5e3,showClose:!0,message:"暂无发货单明细！"})}}},dialogOpen:function(){},dialogClose:function(e){this.rowTableList=[],this.customerId="",this.deliverDtlIds="",this.$emit("close-dialog",e||{})},closeDialog:function(e){}},computed:{fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}}},n=a("KHd+"),s=Object(n.a)(l,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:e.initData.dialog_width},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?a(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[a("el-form",{ref:"submitForm",staticStyle:{"padding-top":"10px","padding-right":"20px","padding-left":"20px"},attrs:{rules:e.rules,model:e.formData,"label-position":"right","label-width":"90px"}},[a("el-row",[a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"退货类型:",prop:"typeName"}},[a("base-input-select",{attrs:{data:e.typeData.data},on:{callback:e.typeSelect},model:{value:e.typeData.defaultSelected,callback:function(t){e.$set(e.typeData,"defaultSelected",t)},expression:"typeData.defaultSelected"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"客户名称:",prop:"customerName"}},[a("el-input",{attrs:{readonly:!0},model:{value:e.formData.customerName,callback:function(t){e.$set(e.formData,"customerName",t)},expression:"formData.customerName"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"制单人:",prop:"makeName"}},[a("el-input",{attrs:{readonly:!0},model:{value:e.formData.cuserName,callback:function(t){e.$set(e.formData,"cuserName",t)},expression:"formData.cuserName"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:6}},[a("el-form-item",{attrs:{label:"备注:",prop:"remark"}},[a("el-input",{model:{value:e.formData.remark,callback:function(t){e.$set(e.formData,"remark",t)},expression:"formData.remark"}})],1)],1)],1),e._v(" "),a("el-row",{style:e.initData.orderDetail_style},[a("custom-base-table",{ref:"retreatEditDialog",attrs:{isSortable:!1,varList:e.tableData,keyValue:!1,showIndex:!0,showTableSet:!1,customColumn:e.customColumn,apiObj:e.apiObj,mergeTitle:e.mergeTitle,mergeColumn:e.mergeColumn,mergeRow:e.mergeRow,componentId:"retreatEditDialog",useDefaultBtn:!0,showAll:!1},on:{databridge:e.databridge}})],1)],1),e._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),a("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);s.options.__file="dialogEdit.vue";t.default=s.exports}}]);