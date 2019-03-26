(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-1c05","chunk-24db","7qJL","o+uy","3n4a","Aw+t"],{"2vmZ":function(t,e,i){},"3n4a":function(t,e,i){"use strict";i.r(e);i("rE2o"),i("ioFf"),i("Oyvg");var a=i("EXX/");function n(t){return(n="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var o={components:{},name:"dialog-add",props:["initData","visible"],data:function(){return{rules:{paymentSum:[{required:!0,message:"请填写付款金额",trigger:"change"}]},dialogLoading:!0,isVisible:!1,inDialog:!0,formData:{},openDialogName:"",showDialog:!1,inLinVisible:!1,formTemp:[]}},created:function(){this.initData.rowData&&(this.formData=this.initData.rowData)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=n(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},isNumberByValue:function(t){return null!=t&&0!=t.trim().length&&new RegExp("^[0-9]+([.]{1}[0-9]{1,2})?$").test(t.trim())},isErrorByCheckPaymentSum:function(t){var e=0;return null!=this.formData.nowPaymentSum&&this.formData.nowPaymentSum.trim().length>0&&(e=this.formData.nowPaymentSum.trim()),this.isNumberByValue(t.trim())?t-e>0&&(this.$message({message:"退款金额:"+t+" 输入错误，退款金额不可大于付款金额(本期)！",type:"warning",duration:5e3}),!0):(this.$message({message:"退款金额:"+t+" 输入错误，请输入大于零的正整数或(1,2)位小数！",type:"warning",duration:5e3}),!0)},save:function(){var t=this;this.$refs.submitForm.validate(function(e){var i=t.formData.paymentSum;t.isErrorByCheckPaymentSum(i)||Object(a.backPaymentRecord)(t.formData).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"退款成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(t){})})},closeDialog:function(t){}}},l=i("KHd+"),s=Object(l.a)(o,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"新增",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"400px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{width:"570px",margin:"10px auto"},attrs:{rules:t.rules,model:t.formData,"label-position":"right","label-width":"120px"}},[i("el-row",[i("el-form-item",{attrs:{label:"供应商编号:"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{readonly:!0},model:{value:t.formData.supplierCode,callback:function(e){t.$set(t.formData,"supplierCode",e)},expression:"formData.supplierCode"}})],1)],1),t._v(" "),i("el-row",[i("el-form-item",{attrs:{label:"供应商名称:"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{readonly:!0},model:{value:t.formData.supplierName,callback:function(e){t.$set(t.formData,"supplierName",e)},expression:"formData.supplierName"}})],1)],1),t._v(" "),i("el-row",[i("el-form-item",{attrs:{label:"付款金额(本期):"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{readonly:!0},model:{value:t.formData.nowPaymentSum,callback:function(e){t.$set(t.formData,"nowPaymentSum",e)},expression:"formData.nowPaymentSum"}})],1)],1),t._v(" "),i("el-row",[i("el-form-item",{attrs:{label:"退款金额:",prop:"paymentSum"}},[i("el-input",{staticStyle:{width:"200px"},on:{change:t.isErrorByCheckPaymentSum},model:{value:t.formData.paymentSum,callback:function(e){t.$set(t.formData,"paymentSum",e)},expression:"formData.paymentSum"}})],1)],1)],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,null,null);s.options.__file="backPaymentRecord.vue";e.default=s.exports},"7qJL":function(t,e,i){"use strict";i.r(e);i("rE2o"),i("ioFf"),i("Oyvg");var a=i("YQ/6");function n(t){return(n="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var o={components:{},name:"dialog-add",props:["initData","visible"],data:function(){return{initialPeriodDate:null,paymentPeriodDate:null,rules:{paymentPeriodDate:[{required:!0,message:"请填写付款期间",trigger:"change"}],paymentType:[{required:!0,message:"请选择付款类型",trigger:"change"}],paymentSum:[{required:!0,message:"请填写期初金额",trigger:"change"}]},dialogLoading:!0,isVisible:!1,inDialog:!0,formData:{},openDialogName:"",showDialog:!1,inLinVisible:!1,formTemp:[]}},created:function(){this.initData.rowData&&(this.formData=this.initData.rowData,this.initialPeriodDate=new Date(this.initData.rowData.initialPeriodDate),null!=this.initData.rowData.paymentPeriodDate&&(this.paymentPeriodDate=new Date(this.initData.rowData.paymentPeriodDate)))},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=n(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},isNumberByValue:function(t){return null!=t&&0!=t.trim().length&&new RegExp("^[0-9]+([.]{1}[0-9]{1,2})?$").test(t.trim())},checkNumberByValue:function(t,e){var i="";return null!=t&&t.trim().length>0&&!this.isNumberByValue(t.trim())?i=i+e+":"+t+" 输入错误，请输入大于零的正整数或(1,2)位小数！":t-0<=0&&(i=i+e+":"+t+" 输入错误，请输入大于零的正整数或(1,2)位小数！"),i},checkPaymentSum:function(t){var e=this.checkNumberByValue(t+"","期初金额");return null!=e&&e.trim().length>0&&(this.$message({message:e,type:"warning",duration:5e3}),!0)},save:function(){var t=this;this.$refs.submitForm.validate(function(e){var i=t.formData.paymentSum;e&&!t.checkPaymentSum(i)&&Object(a.editPaymentBuild)(t.formData).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"设定成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(t){})})},closeDialog:function(t){}}},l=i("KHd+"),s=Object(l.a)(o,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"新增",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"400px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{width:"570px",margin:"10px auto"},attrs:{rules:t.rules,model:t.formData,"label-position":"right","label-width":"120px"}},[i("el-row",[i("el-form-item",{attrs:{label:"供应商编码:"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{readonly:!0},model:{value:t.formData.supplierCode,callback:function(e){t.$set(t.formData,"supplierCode",e)},expression:"formData.supplierCode"}})],1)],1),t._v(" "),i("el-row",[i("el-form-item",{attrs:{label:"供应商名称:"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{readonly:!0},model:{value:t.formData.supplierName,callback:function(e){t.$set(t.formData,"supplierName",e)},expression:"formData.supplierName"}})],1)],1),t._v(" "),i("el-row",[i("el-form-item",{attrs:{label:"付款期间:",prop:"paymentPeriodDate"}},[i("el-date-picker",{staticStyle:{width:"200px"},attrs:{type:"month","value-format":"yyyy-MM-dd",placeholder:"选择月"},model:{value:t.formData.paymentPeriodDate,callback:function(e){t.$set(t.formData,"paymentPeriodDate",e)},expression:"formData.paymentPeriodDate"}})],1)],1),t._v(" "),i("el-form-item",{attrs:{label:"付款类型:",prop:"paymentType"}},[i("el-select",{model:{value:t.formData.paymentType,callback:function(e){t.$set(t.formData,"paymentType",e)},expression:"formData.paymentType"}},[i("el-option",{attrs:{label:"应付款",value:"plus"}}),t._v(" "),i("el-option",{attrs:{label:"预付款",value:"minus"}})],1)],1),t._v(" "),i("el-row",[i("el-form-item",{attrs:{label:"期初金额:",prop:"paymentSum"}},[i("el-input",{staticStyle:{width:"200px"},on:{change:t.checkPaymentSum},model:{value:t.formData.paymentSum,callback:function(e){t.$set(t.formData,"paymentSum",e)},expression:"formData.paymentSum"}})],1)],1)],1),t._v(" "),i("div",{staticStyle:{"padding-left":"6%"}},[t._v("\n      备注："),i("br"),t._v("\n      供应商在付款期间中设定期初金额"),i("br"),t._v("\n      期初金额：含有(期初应付款，期初预付款)中的一项"),i("br"),t._v("\n      例如：付款期间(201903) 表示2019年03月份"),i("br"),i("br")]),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,null,null);s.options.__file="dialogEdit.vue";e.default=s.exports},"Aw+t":function(t,e,i){"use strict";i.r(e);i("rE2o"),i("ioFf");var a=i("uTIz"),n=i("2+ib");i("EXX/");function o(t){return(o="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var l={components:{searchBar:a.a,multilevelTable:n.a},name:"dialog-add",props:["initData","visible"],data:function(){return{searchList:[{label:"供应商编号",type:"input",ruleType:"string",mapKey:"supplierCode",configs:{},placeholder:"供应商编号"},{label:"供应商名称",type:"input",ruleType:"string",mapKey:"supplierName",configs:{},placeholder:"供应商名称"},{label:"付款日期起",type:"date",ruleType:"date",mapKey:"beginDate",configs:{clearable:!0,name:"",type:"date",pickerOptions:{}},placeholder:"请选择"},{label:"付款日期止",type:"date",ruleType:"date",mapKey:"endDate",configs:{clearable:!0,name:"",type:"date",pickerOptions:{}},placeholder:"请选择"}],dialogLoading:!0,isVisible:!1,inDialog:!0,formData:{},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{},dataList:[],tableConfigList:[{customColumn:[],apiObj:{apiName:"listPagePurchasePaymentRecord",params:{fieldCode:"supplierCode,supplierName,typeName,paymentSum,backSum,cdateStr"}},tempData:{},showIndex:!0,showCheckBox:!0,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",headerStyle:{"background-color":"#E4F3FA"},rowStyle:{"background-color":"#E4F3FA"}}]}},created:function(){},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=o(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{sendGuid:function(t){this.guid=t},searchMap:function(t){this.searchObj=t,this.updateData(t)},databridge:function(t){this.dataList=t},dialogOpen:function(){},dialogClose:function(t){this.$emit("close-dialog",t||{})},updateData:function(t){this.$refs.customBaseTable.updateData(t)},closeDialog:function(t){}}},s=i("KHd+"),r=Object(s.a)(l,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"新增",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:t.initData.dialog_width},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),t.searchList.length?i("search-bar",{attrs:{searchList:t.searchList},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),i("el-row",{style:t.initData.table_style},[i("multilevel-table",{ref:"customBaseTable",attrs:{tableConfigList:t.tableConfigList},on:{databridge:t.databridge}})],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)},[],!1,null,null,null);r.options.__file="listPaymentRecord.vue";e.default=r.exports},UulW:function(t,e,i){"use strict";i.r(e);i("rGqo");var a=i("uTIz"),n=i("2+ib"),o=i("o+uy"),l=i("3n4a"),s=i("Aw+t"),r=i("kKEA"),u=i("Vobf"),c=i("hZMg"),d=i("/a8v"),m=i("YQ/6"),p=i("iUVV"),f={components:{multilevelTable:n.a,searchBar:a.a,addPaymentRecord:o.default,backPaymentRecord:l.default,listPaymentRecord:s.default,listSupplierPaymentBuild:r.default},data:function(){return{searchList:[{label:"供应商编码",type:"input",ruleType:"string",mapKey:"supplierCode",configs:{},placeholder:"供应商编码"},{label:"供应商名称",type:"input",ruleType:"string",mapKey:"supplierName",configs:{},placeholder:"供应商名称"}],guid:"",searchObj:{},configs:{topBarBtnList:[{name:"结转",nameEn:"auditOrder",isShow:!0,icon:"add",method:this.frontPaymentHistory},{name:"反结转",nameEn:"auditOrder",isShow:!0,icon:"add",method:this.backPaymentHistory}]},tableConfigList:[{customColumn:[{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"付款",nameEn:"reback",editBtns_isShow:!0,icon:"reback",method:this.addPaymentRecord},{name:"退款",nameEn:"reback",editBtns_isShow:!0,icon:"reback",method:this.backPaymentRecord},{name:"付款记录",nameEn:"reback",editBtns_isShow:!0,icon:"reback",method:this.listPaymentRecord}]}],apiObj:{apiName:"listPagePurchasePaymentHistory",params:{fieldCode:"supplierCode,supplierName,paymentPeriod,beginPlus,beginMinus,nowOrderSum,nowPaymentSum,endPlus,endMinus"}},tempData:{},showIndex:!0,showCheckBox:!1,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",headerStyle:{"background-color":"#E4F3FA"},rowStyle:{"background-color":"#E4F3FA"}}],selectList:[],temp:{},tempLable:{},openDialogName:"",showDialog:!1,visible:!1,dialogData:{dialog_width:"",table_style:"",rowData:{},title:""}}},beforeCreate:function(){},created:function(){this.initButtons()},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{initButtons:function(){var t=this;t.$loading({spinner:"none",text:"智 造 云 管 家"});var e=t.$storage.get("userInfo").roleIds,i=t.$storage.get("menuId");e&&Object(u.initMenuButtons)({menuId:i,roleId:e}).then(function(e){var i=e.buttonList;i&&i.forEach(function(e){t.configs&&(t.configs.queryBarBtnList&&t.configs.queryBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}),t.configs.topBarBtnList&&t.configs.topBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}))}),t.$loading().close()}).catch(function(e){t.$loading().close()})},sendGuid:function(t){this.guid=t},searchMap:function(t){this.searchObj=t,this.updateData(t)},databridge:function(t){this.selectList=t},updateData:function(t){this.$refs.customBaseTable.updateData(t)},frontPaymentHistory:function(){var t=this;Object(d.findPaymentPeriodByCompanyId)().then(function(e){if(0==e.code&&null!=e.paymentPeriod&&e.paymentPeriod.trim().length>0){var i=e.initialPeriod.trim(),a=e.paymentPeriod.trim();a-i==0&&Object(m.checkIsAllBuildSupplierPayment)().then(function(e){null!=e.isAllBuild&&"false"==e.isAllBuild&&t.$confirm("当前付款期间("+a+")含有供应商期初值未设定, 是否进行设定?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){var e=.7*document.body.clientWidth;t.dialogData.dialog_width=e+"px";var i=.75*(.618*e)+"px";t.dialogData.table_style="height:"+i+";width: 96%;margin-left: 2%;",t.dialogData.title="供应商期初值设定",t.openDialogName="listSupplierPaymentBuild",t.showDialog=!0,t.visible=!0}).catch(function(){t.$message({type:"info",message:"已取设定"})})}).catch(function(t){}),Object(c.findSystemDateTime)({dateFormat:"yyyyMM"}).then(function(e){if(0==e.code&&null!=e.sysDateTime&&e.sysDateTime.trim().length>0){var i=e.sysDateTime.trim();if(a-i==0)return void t.$message({type:"warning",duration:5e3,showClose:!0,message:"付款期间("+a+")与当前自然月相同，不可结转操作！"});t.$confirm("付款期间("+a+") 将要执行结转操作，是否执行结转?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){t.$refs.customBaseTable.getData();var e=[];t.selectList.forEach(function(t){var i={supplierId:t.supplierId,paymentPeriod:t.paymentPeriod,beginPlus:t.beginPlus,beginMinus:t.beginMinus,beginValue:t.beginValue,nowOrderSum:t.nowOrderSum,nowReceiveSum:t.nowReceiveSum,endPlus:t.endPlus,endMinus:t.endMinus,endValue:t.endValue};e.push(i)});var i=JSON.stringify(e);Object(p.addPurchasePaymentHistory)({listJsonStr:i}).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"结转成功",type:"success",duration:2e3}),t.updateData(t.searchObj))}).catch(function(t){})}).catch(function(){t.$message({type:"info",message:"已取消结转"})})}}).catch(function(t){})}}).catch(function(t){})},backPaymentHistory:function(){var t=this;Object(d.findPaymentPeriodByCompanyId)().then(function(e){if(0==e.code&&null!=e.paymentPeriod&&e.paymentPeriod.trim().length>0){var i=e.initialPeriod.trim(),a=e.paymentPeriod.trim();if(a-i==0)return void t.$message({type:"warning",duration:5e3,showClose:!0,message:"付款期间("+a+")与该企业设定的初始付款期间相同，不可反结转操作！"});t.$confirm("付款期间("+a+") 将要执行反结转操作，是否执行反结转?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(p.backPurchasePaymentHistory)().then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"反结转成功",type:"success",duration:2e3}),t.updateData(t.searchObj))}).catch(function(t){})}).catch(function(){t.$message({type:"info",message:"已取消反结转"})})}})},addPaymentRecord:function(t,e){var i=this;Object(d.findPaymentPeriodByCompanyId)().then(function(e){if(0==e.code&&null!=e.paymentPeriod&&e.paymentPeriod.trim().length>0){e.initialPeriod.trim();var a=e.paymentPeriod.trim();Object(c.findSystemDateTime)({dateFormat:"yyyyMM"}).then(function(e){if(0==e.code&&null!=e.sysDateTime&&e.sysDateTime.trim().length>0){var n=e.sysDateTime.trim();if(a-n!=0)return void i.$message({type:"warning",duration:5e3,showClose:!0,message:"付款期间("+a+")与当前自然月不相同，不可付款操作！"});i.dialogData.rowData={supplierId:t.supplierId,type:"1",paymentSum:"",supplierCode:t.supplierCode,supplierName:t.supplierName,endPlus:t.endPlus,endMinus:t.endMinus},i.dialogData.title="付款",i.openDialogName="addPaymentRecord",i.showDialog=!0,i.visible=!0}}).catch(function(t){})}})},backPaymentRecord:function(t,e){var i=this;Object(d.findPaymentPeriodByCompanyId)().then(function(e){if(0==e.code&&null!=e.paymentPeriod&&e.paymentPeriod.trim().length>0){e.initialPeriod.trim();var a=e.paymentPeriod.trim();Object(c.findSystemDateTime)({dateFormat:"yyyyMM"}).then(function(e){if(0==e.code&&null!=e.sysDateTime&&e.sysDateTime.trim().length>0){var n=e.sysDateTime.trim();if(a-n!=0)return void i.$message({type:"warning",duration:5e3,showClose:!0,message:"付款期间("+a+")与当前自然月不相同，不可退款操作！"});i.dialogData.rowData={supplierId:t.supplierId,type:"2",paymentSum:"",supplierCode:t.supplierCode,supplierName:t.supplierName,nowPaymentSum:t.nowPaymentSum},i.dialogData.title="退款",i.openDialogName="backPaymentRecord",i.showDialog=!0,i.visible=!0}}).catch(function(t){})}})},listPaymentRecord:function(t,e){var i=.7*document.body.clientWidth;this.dialogData.dialog_width=i+"px";var a=.75*(.618*i)+"px";this.dialogData.table_style="height:"+a+";width: 96%;margin-left: 2%;",this.dialogData.title="付款记录",this.openDialogName="listPaymentRecord",this.showDialog=!0,this.visible=!0},closeDialog:function(t){this.showDialog=!1,"ok"===t.resState&&this.updateData(this.searchObj)},resetTemp:function(){for(var t in this.temp)this.temp[t]=""}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{}},g=(i("wlTy"),i("KHd+")),h=Object(g.a)(f,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"paymentManager"},[t.searchList.length?i("search-bar",{attrs:{searchList:t.searchList},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),i("el-row",{staticClass:"tableTopBar"},[i("el-col",[i("div",{staticClass:"tableBtns"},[t._l(t.configs.topBarBtnList,function(t,e){return[i("base-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"item.isShow"}],attrs:{name:t.name,icon:t.icon,plain:t.plain,state:t.state},on:{myclick:t.method}})]})],2)])],1),t._v(" "),i("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:t.tableHeight+"px"}},[i("el-col",{staticClass:"tableStyle"},[i("div",{staticClass:"baseTable"},[i("el-row",{staticClass:"tableContent"},[i("multilevel-table",{ref:"customBaseTable",attrs:{tableConfigList:t.tableConfigList},on:{databridge:t.databridge}})],1)],1)])],1),t._v(" "),t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visible},on:{"close-dialog":t.closeDialog}}):t._e()],1)},[],!1,null,null,null);h.options.__file="index.vue";e.default=h.exports},kKEA:function(t,e,i){"use strict";i.r(e);i("rE2o"),i("ioFf");var a=i("uTIz"),n=i("2+ib");i("7qJL");function o(t){return(o="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var l={components:{searchBar:a.a,multilevelTable:n.a},name:"dialog-add",props:["initData","visible"],data:function(){return{searchList:[{label:"供应商编号",type:"input",ruleType:"string",mapKey:"supplierCode",configs:{},placeholder:"供应商编号"},{label:"供应商名称",type:"input",ruleType:"string",mapKey:"supplierName",configs:{},placeholder:"供应商名称"}],dialogLoading:!0,isVisible:!1,inDialog:!0,formData:{},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{},dataList:[],tableConfigList:[{customColumn:[{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"设定",nameEn:"reback",editBtns_isShow:!0,icon:"reback",method:this.editPaymentBuild}]}],apiObj:{apiName:"listPagePurchasePaymentBuild",params:{fieldCode:"supplierCode,supplierName,paymentPeriod,beginPlus,beginMinus,isBuildName,cdateStr",isNotBuild:"true"}},tempData:{},showIndex:!0,showCheckBox:!0,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",headerStyle:{"background-color":"#E4F3FA"},rowStyle:{"background-color":"#E4F3FA"}}]}},created:function(){},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=o(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{sendGuid:function(t){this.guid=t},searchMap:function(t){this.searchObj=t,this.updateData(t)},databridge:function(t){this.dataList=t},dialogOpen:function(){},dialogClose:function(t){this.$emit("close-dialog",t||{})},updateData:function(t){this.$refs.customBaseTable.updateData(t)},editPaymentBuild:function(t,e){var i="",a="",n=t.beginValue;n-0>=0?(a="plus",i=n):n-0<0&&(a="minus",i=-1*(n-0)),this.dialogData.rowData={id:t.id,supplierId:t.supplierId,paymentPeriodDate:t.paymentPeriodDate,beginPlus:t.beginPlus,beginMinus:t.beginMinus,beginValue:t.beginValue,paymentType:a,paymentSum:i,supplierCode:t.supplierCode,supplierName:t.supplierName},this.dialogData.title="供应商付款期间设定初期值",this.openDialogName="dialogEdit",this.showDialog=!0,this.visible=!0},closeDialog:function(t){this.showDialog=!1,"ok"===t.resState&&this.updateData(this.searchObj)}}},s=i("KHd+"),r=Object(s.a)(l,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"新增",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:t.initData.dialog_width},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),t.searchList.length?i("search-bar",{attrs:{searchList:t.searchList},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),i("el-row",{style:t.initData.table_style},[i("multilevel-table",{ref:"customBaseTable",attrs:{tableConfigList:t.tableConfigList},on:{databridge:t.databridge}})],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)},[],!1,null,null,null);r.options.__file="listSupplierPaymentBuild.vue";e.default=r.exports},"o+uy":function(t,e,i){"use strict";i.r(e);i("rE2o"),i("ioFf"),i("Oyvg");var a=i("EXX/");function n(t){return(n="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var o={components:{},name:"dialog-add",props:["initData","visible"],data:function(){return{rules:{paymentSum:[{required:!0,message:"请填写付款金额",trigger:"change"}]},dialogLoading:!0,isVisible:!1,inDialog:!0,formData:{},openDialogName:"",showDialog:!1,inLinVisible:!1,formTemp:[]}},created:function(){this.initData.rowData&&(this.formData=this.initData.rowData)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=n(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},isNumberByValue:function(t){return null!=t&&0!=t.trim().length&&new RegExp("^[0-9]+([.]{1}[0-9]{1,2})?$").test(t.trim())},isErrorByCheckPaymentSum:function(t){var e=0;return null!=this.formData.endPlus&&this.formData.endPlus.trim().length>0&&(e=this.formData.endPlus.trim()),this.isNumberByValue(t.trim())?t-e>0&&(this.$message({message:"付款金额:"+t+" 输入错误，付款金额不可大于应付款(期末)！",type:"warning",duration:5e3}),!0):(this.$message({message:"付款金额:"+t+" 输入错误，请输入大于零的正整数或(1,2)位小数！",type:"warning",duration:5e3}),!0)},save:function(){var t=this;this.$refs.submitForm.validate(function(e){var i=t.formData.paymentSum;t.isErrorByCheckPaymentSum(i)||Object(a.addPaymentRecord)(t.formData).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"付款成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(t){})})},closeDialog:function(t){}}},l=i("KHd+"),s=Object(l.a)(o,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"新增",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"400px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{width:"570px",margin:"10px auto"},attrs:{rules:t.rules,model:t.formData,"label-position":"right","label-width":"120px"}},[i("el-row",[i("el-form-item",{attrs:{label:"供应商编号:"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{readonly:!0},model:{value:t.formData.supplierCode,callback:function(e){t.$set(t.formData,"supplierCode",e)},expression:"formData.supplierCode"}})],1)],1),t._v(" "),i("el-row",[i("el-form-item",{attrs:{label:"供应商名称:"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{readonly:!0},model:{value:t.formData.supplierName,callback:function(e){t.$set(t.formData,"supplierName",e)},expression:"formData.supplierName"}})],1)],1),t._v(" "),i("el-row",[i("el-form-item",{attrs:{label:"应付款(期末):"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{readonly:!0},model:{value:t.formData.endPlus,callback:function(e){t.$set(t.formData,"endPlus",e)},expression:"formData.endPlus"}})],1)],1),t._v(" "),i("el-row",[i("el-form-item",{attrs:{label:"付款金额:",prop:"paymentSum"}},[i("el-input",{staticStyle:{width:"200px"},on:{change:t.isErrorByCheckPaymentSum},model:{value:t.formData.paymentSum,callback:function(e){t.$set(t.formData,"paymentSum",e)},expression:"formData.paymentSum"}})],1)],1)],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,null,null);s.options.__file="addPaymentRecord.vue";e.default=s.exports},wlTy:function(t,e,i){"use strict";var a=i("2vmZ");i.n(a).a}}]);