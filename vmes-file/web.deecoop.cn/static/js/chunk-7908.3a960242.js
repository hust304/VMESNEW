(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-7908"],{"/NOw":function(e,t,a){"use strict";var i=a("QW4X");a.n(i).a},QW4X:function(e,t,a){},"Y/E/":function(e,t,a){"use strict";a.r(t);a("rE2o"),a("ioFf"),a("pIFo");var i=a("9WTv");function l(e){return(l="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var o={name:"dialog-add",props:["initData","visible"],components:{},data:function(){var e=this;return{dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{deptName:!0},tempShow:{deptName:!0},rules:{name:[{required:!0,message:"请填写设备名称",trigger:"change"}],typeName:[{required:!0,trigger:"change",validator:function(t,a,i){e.selectDataType.defaultSelected.length<=0?i(new Error("请选择设备类型")):i()}}]},selectDataType:{data:{selectUrl:"/system/dictionary/getDictionarys",selectParm:{dictionaryKey:"equipmentType"}},defaultSelected:[]},fileData:{photoDir:"equipment/"},uploadUrl:"https://web.ouhaicloud.com//fileIO/file/uploadPhoto",imageUrl:""}},created:function(){this.initData.temp&&(this.temp=this.initData.temp,this.initData.temp.photo&&(this.imageUrl="https://web.ouhaicloud.com/"+this.initData.temp.photo)),this.initData.tempLable&&(this.tempLable=this.initData.tempLable)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=l(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},dialogClose:function(e){this.$emit("close-dialog",e||{})},typeSelect:function(e,t){e[0]?(this.temp.type=e[0],this.selectDataType.defaultSelected=[e[0]]):(this.temp.type=[],this.selectDataType.defaultSelected=[])},handleAvatarSuccess:function(e){if(0==e.code){var t=e.photo;null!=t&&t.trim().length>0&&(this.temp.photo=t,this.imageUrl="https://web.ouhaicloud.com/"+t),this.$message({message:"图片上传成功！",type:"success",duration:5e3})}else 0!=e.code&&null!=e.msg&&e.msg.trim().length>0&&this.$message.error(e.msg.trim())},beforeAvatarUpload:function(e){var t=e.type;if(t=t.replace("image/",""),-1!="jpg,jpeg,png".indexOf(t)){e.size>5242880&&this.$message({message:"上传员工照片大小不能超过 5MB!",type:"error",duration:5e3})}else this.$message({message:"上传员工照片只能是(jpg,jpeg,png)格式文件!",type:"error",duration:5e3})},save:function(){var e=this;this.$refs.submitForm.validate(function(t){t&&(e.dialogLoading=!0,Object(i.addEquipment)(e.temp).then(function(t){e.dialogLoading=!1,0===t.code&&(e.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),e.isVisible=!1,e.dialogClose({resState:"ok"}))}).catch(function(t){console.log(t),e.dialogLoading=!1}))})}}},s=(a("/NOw"),a("KHd+")),n=Object(s.a)(o,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],staticStyle:{height:"90vh"},attrs:{title:e.initData.title?e.initData.title:"新增",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"700px",top:"10vh","custom-class":"listDeliverClass"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}],staticStyle:{height:"100%",overflow:"auto"}},[a("el-form",{ref:"submitForm",staticStyle:{width:"400px","padding-top":"10px"},attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"120px"}},[a("el-row",[a("el-col",{staticStyle:{"text-align":"center","padding-bottom":"20px"},attrs:{span:24}},[a("el-upload",{staticClass:"avatar-uploader",attrs:{name:"fileName",action:e.uploadUrl,data:e.fileData,"show-file-list":!1,"on-success":e.handleAvatarSuccess,"before-upload":e.beforeAvatarUpload}},[e.imageUrl?a("img",{staticClass:"avatar",attrs:{src:e.imageUrl}}):a("i",{staticClass:"el-icon-plus avatar-uploader-icon"})])],1)],1),e._v(" "),a("el-row",[a("el-col",{attrs:{span:24}},[a("el-form-item",{directives:[{name:"show",rawName:"v-show",value:e.tempShow.deptName,expression:"tempShow.deptName"}],attrs:{label:e.tempLable.deptName+":",prop:"code"}},[a("el-input",{attrs:{disabled:e.tempNotEditable.deptName},model:{value:e.temp.deptName,callback:function(t){e.$set(e.temp,"deptName",t)},expression:"temp.deptName"}})],1),e._v(" "),a("el-form-item",{attrs:{label:e.tempLable.name+":",prop:"name"}},[a("el-input",{model:{value:e.temp.name,callback:function(t){e.$set(e.temp,"name",t)},expression:"temp.name"}})],1),e._v(" "),a("el-form-item",{attrs:{label:e.tempLable.spec+":",prop:"spec"}},[a("el-input",{model:{value:e.temp.spec,callback:function(t){e.$set(e.temp,"spec",t)},expression:"temp.spec"}})],1),e._v(" "),a("el-form-item",{attrs:{label:e.tempLable.typeName+":",prop:"typeName"}},[a("base-input-select",{staticStyle:{width:"280px"},attrs:{placeholder:e.tempLable.typeName,data:e.selectDataType.data},on:{callback:e.typeSelect},model:{value:e.selectDataType.defaultSelected,callback:function(t){e.$set(e.selectDataType,"defaultSelected",t)},expression:"selectDataType.defaultSelected"}})],1),e._v(" "),a("el-form-item",{attrs:{label:e.tempLable.supplier+":",prop:"supplier"}},[a("el-input",{model:{value:e.temp.supplier,callback:function(t){e.$set(e.temp,"supplier",t)},expression:"temp.supplier"}})],1),e._v(" "),a("el-form-item",{attrs:{label:e.tempLable.buyDate+":",prop:"buyDate"}},[a("el-date-picker",{staticStyle:{width:"280px"},attrs:{type:"date",placeholder:"选择日期","value-format":"yyyy-MM-dd"},model:{value:e.temp.buyDate,callback:function(t){e.$set(e.temp,"buyDate",t)},expression:"temp.buyDate"}})],1),e._v(" "),a("el-form-item",{attrs:{label:e.tempLable.remark+":",prop:"remark"}},[a("el-input",{model:{value:e.temp.remark,callback:function(t){e.$set(e.temp,"remark",t)},expression:"temp.remark"}})],1)],1)],1)],1),e._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),a("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)])},[],!1,null,null,null);n.options.__file="dialogAdd.vue";t.default=n.exports}}]);