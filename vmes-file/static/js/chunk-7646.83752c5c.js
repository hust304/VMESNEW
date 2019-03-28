(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-7646","7qJL"],{"7qJL":function(e,t,i){"use strict";i.r(t);i("rE2o"),i("ioFf"),i("Oyvg");var a=i("YQ/6");function o(e){return(o="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var n={components:{},name:"dialog-add",props:["initData","visible"],data:function(){return{initialPeriodDate:null,paymentPeriodDate:null,rules:{paymentPeriodDate:[{required:!0,message:"请填写付款期间",trigger:"change"}],paymentType:[{required:!0,message:"请选择付款类型",trigger:"change"}],paymentSum:[{required:!0,message:"请填写期初金额",trigger:"change"}]},dialogLoading:!0,isVisible:!1,inDialog:!0,formData:{},openDialogName:"",showDialog:!1,inLinVisible:!1,formTemp:[]}},created:function(){this.initData.rowData&&(this.formData=this.initData.rowData,this.initialPeriodDate=new Date(this.initData.rowData.initialPeriodDate),null!=this.initData.rowData.paymentPeriodDate&&(this.paymentPeriodDate=new Date(this.initData.rowData.paymentPeriodDate)))},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=o(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},dialogClose:function(e){this.$emit("close-dialog",e||{})},isNumberByValue:function(e){return null!=e&&0!=e.trim().length&&new RegExp("^[0-9]+([.]{1}[0-9]{1,2})?$").test(e.trim())},checkNumberByValue:function(e,t){var i="";return null!=e&&e.trim().length>0&&!this.isNumberByValue(e.trim())?i=i+t+":"+e+" 输入错误，请输入大于零的正整数或(1,2)位小数！":e-0<=0&&(i=i+t+":"+e+" 输入错误，请输入大于零的正整数或(1,2)位小数！"),i},checkPaymentSum:function(e){var t=this.checkNumberByValue(e+"","期初金额");return null!=t&&t.trim().length>0&&(this.$message({message:t,type:"warning",duration:5e3}),!0)},save:function(){var e=this;this.$refs.submitForm.validate(function(t){var i=e.formData.paymentSum;t&&!e.checkPaymentSum(i)&&Object(a.editPaymentBuild)(e.formData).then(function(t){e.dialogLoading=!1,0===t.code&&(e.$notify({title:"成功",message:"设定成功",type:"success",duration:2e3}),e.isVisible=!1,e.dialogClose({resState:"ok"}))}).catch(function(e){})})},closeDialog:function(e){}}},l=i("KHd+"),s=Object(l.a)(n,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"新增",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"400px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{width:"570px",margin:"10px auto"},attrs:{rules:e.rules,model:e.formData,"label-position":"right","label-width":"120px"}},[i("el-row",[i("el-form-item",{attrs:{label:"供应商编码:"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{readonly:!0},model:{value:e.formData.supplierCode,callback:function(t){e.$set(e.formData,"supplierCode",t)},expression:"formData.supplierCode"}})],1)],1),e._v(" "),i("el-row",[i("el-form-item",{attrs:{label:"供应商名称:"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{readonly:!0},model:{value:e.formData.supplierName,callback:function(t){e.$set(e.formData,"supplierName",t)},expression:"formData.supplierName"}})],1)],1),e._v(" "),i("el-row",[i("el-form-item",{attrs:{label:"付款期间:",prop:"paymentPeriodDate"}},[i("el-date-picker",{staticStyle:{width:"200px"},attrs:{type:"month","value-format":"yyyy-MM-dd",placeholder:"选择月"},model:{value:e.formData.paymentPeriodDate,callback:function(t){e.$set(e.formData,"paymentPeriodDate",t)},expression:"formData.paymentPeriodDate"}})],1)],1),e._v(" "),i("el-form-item",{attrs:{label:"付款类型:",prop:"paymentType"}},[i("el-select",{model:{value:e.formData.paymentType,callback:function(t){e.$set(e.formData,"paymentType",t)},expression:"formData.paymentType"}},[i("el-option",{attrs:{label:"应付款",value:"plus"}}),e._v(" "),i("el-option",{attrs:{label:"预付款",value:"minus"}})],1)],1),e._v(" "),i("el-row",[i("el-form-item",{attrs:{label:"期初金额:",prop:"paymentSum"}},[i("el-input",{staticStyle:{width:"200px"},on:{change:e.checkPaymentSum},model:{value:e.formData.paymentSum,callback:function(t){e.$set(e.formData,"paymentSum",t)},expression:"formData.paymentSum"}})],1)],1)],1),e._v(" "),i("div",{staticStyle:{"padding-left":"6%"}},[e._v("\n      备注："),i("br"),e._v("\n      供应商在付款期间中设定期初金额"),i("br"),e._v("\n      期初金额：含有(期初应付款，期初预付款)中的一项"),i("br"),e._v("\n      例如：付款期间(201903) 表示2019年03月份"),i("br"),i("br")]),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);s.options.__file="dialogEdit.vue";t.default=s.exports},ifQH:function(e,t,i){"use strict";var a=i("pMPb");i.n(a).a},ikbw:function(e,t,i){"use strict";i.r(t);var a=i("uTIz"),o=i("2+ib"),n=i("7qJL"),l=(i("Vobf"),i("hZMg"),i("/a8v"),{components:{multilevelTable:o.a,searchBar:a.a,dialogEdit:n.default},data:function(){return{searchList:[{label:"供应商编码",type:"input",ruleType:"string",mapKey:"supplierCode",configs:{},placeholder:"供应商编码"},{label:"供应商名称",type:"input",ruleType:"string",mapKey:"supplierName",configs:{},placeholder:"供应商名称"}],guid:"",searchObj:{},tableConfigList:[{customColumn:[{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"设定",nameEn:"reback",editBtns_isShow:!0,icon:"reback",method:this.editPaymentBuild}]}],apiObj:{apiName:"listPagePurchasePaymentBuild",params:{fieldCode:"supplierCode,supplierName,paymentPeriod,beginPlus,beginMinus,isBuildName,cdateStr"}},tempData:{},showIndex:!0,showCheckBox:!1,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",headerStyle:{"background-color":"#E4F3FA"},rowStyle:{"background-color":"#E4F3FA"}}],selectList:[],temp:{},tempLable:{},openDialogName:"",showDialog:!1,visible:!1,dialogData:{dialog_width:"",table_style:"",rowData:{},title:""}}},beforeCreate:function(){},created:function(){},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{sendGuid:function(e){this.guid=e},searchMap:function(e){this.searchObj=e,this.updateData(e)},databridge:function(e){this.selectList=e},updateData:function(e){this.$refs.customBaseTable.updateData(e)},editPaymentBuild:function(e,t){var i="",a="",o=e.beginValue;o-0>=0?(a="plus",i=o):o-0<0&&(a="minus",i=-1*(o-0)),this.dialogData.rowData={id:e.id,supplierId:e.supplierId,paymentPeriodDate:e.paymentPeriodDate,beginPlus:e.beginPlus,beginMinus:e.beginMinus,beginValue:e.beginValue,paymentType:a,paymentSum:i,supplierCode:e.supplierCode,supplierName:e.supplierName},this.dialogData.title="供应商付款期间设定初期值",this.openDialogName="dialogEdit",this.showDialog=!0,this.visible=!0},closeDialog:function(e){this.showDialog=!1,"ok"===e.resState&&this.updateData(this.searchObj)},resetTemp:function(){for(var e in this.temp)this.temp[e]=""}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{}}),s=(i("ifQH"),i("KHd+")),r=Object(s.a)(l,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{staticClass:"paymentBuild"},[e.searchList.length?i("search-bar",{attrs:{searchList:e.searchList},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),i("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:e.tableHeight+"px"}},[i("el-col",{staticClass:"tableStyle"},[i("div",{staticClass:"baseTable"},[i("el-row",{staticClass:"tableContent"},[i("multilevel-table",{ref:"customBaseTable",attrs:{tableConfigList:e.tableConfigList},on:{databridge:e.databridge}})],1)],1)])],1),e._v(" "),e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.visible},on:{"close-dialog":e.closeDialog}}):e._e()],1)},[],!1,null,null,null);r.options.__file="index.vue";t.default=r.exports},pMPb:function(e,t,i){}}]);