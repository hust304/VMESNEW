(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-93bf"],{"+CwU":function(e,t,a){"use strict";var l=a("hbz0");a.n(l).a},KbnD:function(e,t,a){"use strict";a.r(t);a("rE2o"),a("ioFf"),a("pIFo");function l(e){return(l="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var i={components:{},name:"dialog-add",props:["initData","visible"],data:function(){return{rules:{},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:""},dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},fileData:{photoDir:"employee/"},imageUrl:"",politicalData:{data:{selectUrl:"/system/dictionary/getDictionarys",selectParm:{dictionaryKey:"political",isglobal:"0"}},defaultSelected:["ebb2eae0e5c3479aa1b19a9251917077"]}}},created:function(){this.temp=this.initData.rowData},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=l(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dataBridge:function(e){},dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},dialogClose:function(e){this.$emit("close-dialog",e||{})},deleteBtns:function(e,t){this.tableData.splice(t,1)},closeDialog:function(e){},handleAvatarSuccess:function(e){console.log(e);if(0==e.code){var t=e.photo;null!=t&&t.trim().length>0&&(this.temp.photo=t,this.imageUrl="https://web.ouhaicloud.com/"+t,console.log(this.imageUrl)),this.$message({message:"图片上传成功！",type:"success",duration:5e3})}else 0!=e.code&&null!=e.msg&&e.msg.trim().length>0&&this.$message.error(e.msg.trim())},beforeAvatarUpload:function(e){var t=e.type;if(t=t.replace("image/",""),-1!="jpg,jpeg,png".indexOf(t)){e.size>5242880&&this.$message({message:"上传员工照片大小不能超过 5MB!",type:"error",duration:5e3})}else this.$message({message:"上传员工照片只能是(jpg,jpeg,png)格式文件!",type:"error",duration:5e3})}},watch:{}},o=(a("+CwU"),a("KHd+")),s=Object(o.a)(i,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"600px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?a(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}],staticStyle:{margin:"10px auto",width:"100%"}},[a("el-form",{ref:"submitForm",staticStyle:{width:"570px","padding-top":"10px"},attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"120px"}},[a("el-row",[a("el-col",{attrs:{span:12}},[a("div",{staticStyle:{"padding-left":"120px"}},[a("el-upload",{staticClass:"avatar-uploader",attrs:{name:"fileName",action:e.temp.uploadUrl,data:e.fileData,"show-file-list":!1,"on-success":e.handleAvatarSuccess,"before-upload":e.beforeAvatarUpload}},[e.imageUrl?a("img",{staticClass:"avatar",attrs:{src:e.imageUrl}}):a("i",{staticClass:"el-icon-plus avatar-uploader-icon"})])],1)]),e._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"员工编号:",prop:"code"}},[a("el-input",{attrs:{readonly:!0},model:{value:e.temp.code,callback:function(t){e.$set(e.temp,"code",t)},expression:"temp.code"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"姓名:",prop:"name"}},[a("el-input",{attrs:{readonly:!0},model:{value:e.temp.name,callback:function(t){e.$set(e.temp,"name",t)},expression:"temp.name"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"性别:",prop:"sexName"}},[a("el-select",{attrs:{disabled:!0},model:{value:e.temp.sex,callback:function(t){e.$set(e.temp,"sex",t)},expression:"temp.sex"}},[a("el-option",{attrs:{label:"男",value:"1"}}),e._v(" "),a("el-option",{attrs:{label:"女",value:"0"}})],1)],1)],1)],1),e._v(" "),a("el-row",[a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"部门:",prop:"deptName"}},[a("el-input",{attrs:{readonly:!0},model:{value:e.temp.deptName,callback:function(t){e.$set(e.temp,"deptName",t)},expression:"temp.deptName"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"岗位:",prop:"postName"}},[a("el-input",{attrs:{readonly:!0},model:{value:e.temp.postName,callback:function(t){e.$set(e.temp,"postName",t)},expression:"temp.postName"}})],1)],1)],1),e._v(" "),a("el-row",[a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"手机号:",prop:"mobile"}},[a("el-input",{attrs:{readonly:!0},model:{value:e.temp.mobile,callback:function(t){e.$set(e.temp,"mobile",t)},expression:"temp.mobile"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"邮箱:",prop:"email"}},[a("el-input",{attrs:{readonly:!0},model:{value:e.temp.email,callback:function(t){e.$set(e.temp,"email",t)},expression:"temp.email"}})],1)],1)],1),e._v(" "),a("el-row",[a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"出生日期:",prop:"birthday"}},[a("el-date-picker",{staticStyle:{width:"165px"},attrs:{type:"date",placeholder:"选择日期","value-format":"yyyy-MM-dd",readonly:!0},model:{value:e.temp.birthday,callback:function(t){e.$set(e.temp,"birthday",t)},expression:"temp.birthday"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"入职日期:",prop:"entryDate"}},[a("el-date-picker",{staticStyle:{width:"165px"},attrs:{type:"date",placeholder:"选择日期","value-format":"yyyy-MM-dd",readonly:!0},model:{value:e.temp.entryDate,callback:function(t){e.$set(e.temp,"entryDate",t)},expression:"temp.entryDate"}})],1)],1)],1),e._v(" "),a("el-row",[a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"籍贯:",prop:"nativePlace"}},[a("el-input",{attrs:{readonly:!0},model:{value:e.temp.nativePlace,callback:function(t){e.$set(e.temp,"nativePlace",t)},expression:"temp.nativePlace"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"政治面貌:",prop:"politicalName"}},[a("base-input-select",{staticStyle:{width:"165px"},attrs:{data:e.politicalData.data,disabled:!0},model:{value:e.politicalData.defaultSelected,callback:function(t){e.$set(e.politicalData,"defaultSelected",t)},expression:"politicalData.defaultSelected"}})],1)],1)],1),e._v(" "),a("el-row",[a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"身份证号:",prop:"identityNumber"}},[a("el-input",{attrs:{readonly:!0},model:{value:e.temp.identityNumber,callback:function(t){e.$set(e.temp,"identityNumber",t)},expression:"temp.identityNumber"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"婚姻状况:",prop:"maritalName"}},[a("el-select",{attrs:{disabled:!0},model:{value:e.temp.marital,callback:function(t){e.$set(e.temp,"marital",t)},expression:"temp.marital"}},[a("el-option",{attrs:{label:"未婚",value:"0"}}),e._v(" "),a("el-option",{attrs:{label:"已婚",value:"1"}})],1)],1)],1)],1),e._v(" "),a("el-row",[a("el-col",{attrs:{span:24}},[a("el-form-item",{attrs:{label:"备注:",prop:"remark"}},[a("el-input",{attrs:{type:"textarea",rows:2,readonly:!0},model:{value:e.temp.remark,callback:function(t){e.$set(e.temp,"remark",t)},expression:"temp.remark"}})],1)],1)],1)],1),e._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);s.options.__file="employeeInfo.vue";t.default=s.exports},hbz0:function(e,t,a){}}]);