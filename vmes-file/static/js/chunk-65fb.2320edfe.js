(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-65fb"],{"/FO0":function(t,e,i){},"8KFu":function(t,e,i){"use strict";var a=i("vjeH");i.n(a).a},"9O1b":function(t,e,i){"use strict";var a=i("/FO0");i.n(a).a},NaOS:function(t,e,i){"use strict";i("rGqo");function a(t,e,i){return e in t?Object.defineProperty(t,e,{value:i,enumerable:!0,configurable:!0,writable:!0}):t[e]=i,t}var o={components:{},name:"dyna-form",props:{config:{type:Object,default:function(){return{}}},formTemp:{type:Array,default:function(){return[]}},props:{type:Object,default:function(){return{key:"key",value:"value"}}}},data:function(){var t=this;return{btnsBoxHeight:0,addFormData:[],isVisible:!1,saveBtnState:!0,tempFormList:[{key:"",value:""}],itemRule:[{validator:function(e,i,a){""===i?(t.saveBtnState=!0,a(new Error("请定义属性名称"))):t.deDuplication(i)?(t.saveBtnState=!0,a(new Error("有重复的属性名称"))):a()},trigger:"blur"}],formData:[]}},created:function(){this.formData=this.renameAttr(this.formTemp,!0)},mounted:function(){this.$nextTick(function(){this.btnsBoxHeight=this.hideBtn?this.$refs.btnsBox.clientHeight:0})},computed:{hideBtn:function(){return!this.config.hideBtn},formList:function(){return this.formData.concat(this.addFormData)},onModal:function(){return!1},onEscape:function(){return!1}},methods:{renameAttr:function(t,e){if("key"===this.props.key&&"value"===this.props.value)return t;var i=this.props,o=i.key,n=i.value,s=[];return e?(t.forEach(function(t,e){s.push({key:t[o||"key"],value:t[n||"value"]})}),s):(this.formList.forEach(function(t,e){var i;s.push((a(i={},o||"key",t.key),a(i,n||"value",t.value),i))}),s)},addAttr:function(){this.tempFormList=[{key:"",value:""}],this.isVisible=!0},removeDomain:function(t,e){var i=this,a=!0;this.formData.forEach(function(e,o){e.key===t.key&&(a=!1,i.formData.splice(o,1))}),a&&this.addFormData.forEach(function(e,a){e.key===t.key&&i.addFormData.splice(a,1)})},dialogOpen:function(){var t=this;this.saveBtnState=!0,this.$nextTick(function(){t.tempFormList.forEach(function(e,i){t.$refs["tempForm"+i][0].clearValidate()})})},getFormList:function(){this.$emit("sent-list",this.renameAttr(this.formList))},save:function(){this.addFormData=this.addFormData.concat(this.tempFormList),this.isVisible=!1},addContent:function(){this.tempFormList.push({key:"",value:""}),this.saveBtnState=!0},deleteContent:function(t,e){this.tempFormList.splice(e,1),this.switchSaveBtnState()},deDuplication:function(t){var e=0;return this.tempFormList.forEach(function(i){i.key===t&&e++}),this.formList.forEach(function(i){i.key===t&&e++}),1!==e},checkInput:function(){this.switchSaveBtnState()},switchSaveBtnState:function(){var t=this;this.$nextTick(function(){var e=0,i=!0;t.tempFormList.forEach(function(a,o){i?t.$refs["tempForm"+o][0].validate(function(t){t||(e++,i=!1)}):t.$refs["tempForm"+o][0].validate(function(t){})}),t.saveBtnState=!t.tempFormList.length||!!e})}}},n=(i("9O1b"),i("KHd+")),s=Object(n.a)(o,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"dynaForm",staticStyle:{height:"100%",position:"relative","box-sizing":"border-box"},style:{paddingTop:t.btnsBoxHeight+"px"}},[t.hideBtn?i("div",{ref:"btnsBox",staticClass:"dynaFormBtn",staticStyle:{position:"absolute",top:"0",right:"0"}},[i("el-button",{attrs:{type:"text",size:"mini",icon:"el-icon-plus"},on:{click:t.addAttr}},[t._v("自定义属性")])],1):t._e(),t._v(" "),i("div",{staticClass:"formBox",staticStyle:{height:"100%","overflow-y":"auto"}},[i("el-form",{ref:"resultForm",staticStyle:{padding:"5px"},attrs:{"label-position":"left","label-width":"75px"}},t._l(t.formList,function(e,a){return i("el-form-item",{key:e.key,attrs:{label:e.key}},[i("el-input",{staticStyle:{width:"calc(100% - 27px)"},attrs:{placeholder:"请输入",clearable:""},model:{value:e.value,callback:function(i){t.$set(e,"value",i)},expression:"item.value"}}),i("el-button",{staticStyle:{padding:"5px"},attrs:{type:"text",icon:"el-icon-remove",title:"删除该项"},on:{click:function(i){i.preventDefault(),t.removeDomain(e,a)}}})],1)}),1)],1),t._v(" "),i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:"自定义属性",visible:t.isVisible,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,width:"400px","append-to-body":""},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen}},[i("div",{staticClass:"addContent",staticStyle:{"box-sizing":"border-box",padding:"5px 10px"}},[i("div",[t._l(t.tempFormList,function(e,a){return[i("el-row",{staticStyle:{position:"relative",border:"1px solid #E4E4E4","border-radius":"4px","margin-bottom":"10px"}},[i("el-form",{ref:"tempForm"+a,refInFor:!0,staticStyle:{width:"90%",padding:"5px"},attrs:{model:e,"label-position":"left","label-width":"75px"}},[i("el-form-item",{staticStyle:{"margin-bottom":"20px"},attrs:{label:"属性名称:",prop:"key",rules:t.itemRule}},[i("el-input",{attrs:{placeholder:"请输入属性名",clearable:""},on:{blur:function(i){t.checkInput(e,a)}},model:{value:e.key,callback:function(i){t.$set(e,"key",i)},expression:"item.key"}})],1),t._v(" "),i("el-form-item",{staticStyle:{"margin-bottom":"0"},attrs:{label:"属性值:"}},[i("el-input",{attrs:{placeholder:"请输入属性值",clearable:""},model:{value:e.value,callback:function(i){t.$set(e,"value",i)},expression:"item.value"}})],1)],1),t._v(" "),i("div",{staticStyle:{position:"absolute",right:"8px",top:"50%",transform:"translate(0,-50%)"}},[i("el-button",{staticStyle:{padding:"5px"},attrs:{type:"text",icon:"el-icon-remove",title:"删除该项"},on:{click:function(i){t.deleteContent(e,a)}}})],1)],1)]})],2),t._v(" "),i("div",{ref:"dialogBtn",staticStyle:{"text-align":"center"}},[i("el-button",{staticStyle:{padding:"5px",width:"100%",border:"1px dashed #E4E4E4"},attrs:{type:"text",size:"medium",icon:"el-icon-plus"},on:{click:t.addContent}},[t._v("新增属性")])],1)]),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary",disabled:t.saveBtnState},on:{click:t.save}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)])],1)},[],!1,null,null,null);s.options.__file="index.vue";e.a=s.exports},Yo6V:function(t,e,i){"use strict";i.r(e);i("rE2o"),i("ioFf"),i("pIFo"),i("Oyvg");var a=i("xMja");function o(t){return(o="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var n={components:{DynaForm:i("NaOS").a},name:"dialog-edit",props:["initData","visible"],data:function(){var t=this;return{dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{},rules:{name:[{required:!0,message:"请填写货品名称",trigger:"change"}],spec:[{required:!0,message:"请填写规格型号",trigger:"change"}],unitName:[{required:!0,trigger:"change",validator:function(e,i,a){t.unitData.defaultSelected.length<=0?a(new Error("请选择计量单位")):a()}}],validityDays:[{type:"number",trigger:"change",validator:function(t,e,i){e<0?i(new Error("保质期必须大于零")):i()}}]},actionUrl:"",imageUrl:"",fileData:{photoDir:"product/"},unitData:{data:{selectUrl:"/system/dictionary/getDictionarys",selectParm:{dictionaryKey:"productUnit",isglobal:"0"}},defaultSelected:[]},lastUnitData:{data:{selectUrl:"/system/dictionary/getDictionarys",selectParm:{dictionaryKey:"productUnit",isglobal:"0"}},defaultSelected:[]},productTypeData:{data:{selectUrl:"/system/dictionary/getDictionarys",selectParm:{dictionaryKey:"productType",isglobal:"0"}},defaultSelected:[]},formTemp:[]}},created:function(){this.initData.temp&&(this.temp=this.initData.temp,this.temp.validityDays||(this.temp.validityDays=0)),this.initData.tempLable&&(this.tempLable=this.initData.tempLable),this.temp.photo?this.imageUrl="http://web.deecoop.cn/"+this.temp.photo:this.imageUrl=""},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=o(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]}},methods:{unitSelect:function(t){this.temp.unit=t[0]},lastUnitSelect:function(t){this.temp.lastUnit=t[0]},productTypeSelect:function(t){this.temp.type=t[0]},checkPrice:function(t){new RegExp("^[0-9]+([.]{1}[0-9]{1,2})?$").test(t)||this.$message({message:"单价:"+t+" 输入错误，请输入大于零的正整数或(1,2)位小数！",type:"warning",duration:5e3})},dialogOpen:function(){var t=this;this.actionUrl="http://web.deecoop.cn//fileIO/file/uploadPhoto",this.unitData.defaultSelected=[],this.unitData.defaultSelected.push(this.temp.unit),this.lastUnitData.defaultSelected=[],this.lastUnitData.defaultSelected.push(this.temp.lastUnit),this.productTypeData.defaultSelected=[],this.productTypeData.defaultSelected.push(this.temp.type);var e=this.temp.prodPropertyJsonStr;null!=e&&e.trim().length>0&&(this.formTemp=JSON.parse(e)),this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},formListResult:function(t){var e="";null!=t&&t.length>0&&(e=JSON.stringify(t)),this.temp.prodProperty=e},save:function(){var t=this;this.$refs.dynaForm.getFormList(),t.$refs.submitForm.validate(function(e){e&&(t.dialogLoading=!0,Object(a.updateProduct)(t.temp).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"修改成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){console.log(e),t.dialogLoading=!1}))})},handleAvatarSuccess:function(t){if(0==t.code){var e=t.photo;null!=e&&e.trim().length>0&&(this.temp.photo=e,this.imageUrl="http://web.deecoop.cn/"+e),this.$message({message:"图片上传成功！",type:"success",duration:5e3})}else 0!=t.code&&null!=t.msg&&t.msg.trim().length>0&&this.$message.error(t.msg.trim())},beforeAvatarUpload:function(t){var e=t.type;if(e=e.replace("image/",""),-1!="jpg,jpeg,png".indexOf(e)){t.size>5242880&&this.$message({message:"上传员工照片大小不能超过 5MB!",type:"error",duration:5e3})}else this.$message({message:"上传员工照片只能是(jpg,jpeg,png)格式文件!",type:"error",duration:5e3})}}},s=(i("apiY"),i("8KFu"),i("KHd+")),l=Object(s.a)(n,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"编辑",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"620px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{width:"570px",margin:"10px auto"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[i("el-row",[i("el-col",{staticStyle:{"padding-left":"150px"},attrs:{span:12}},[i("el-upload",{staticClass:"avatar-uploader",attrs:{name:"fileName",action:t.actionUrl,data:t.fileData,"show-file-list":!1,"on-success":t.handleAvatarSuccess,"before-upload":t.beforeAvatarUpload}},[t.imageUrl?i("img",{staticClass:"avatar",attrs:{src:t.imageUrl}}):i("i",{staticClass:"el-icon-plus avatar-uploader-icon"})])],1),t._v(" "),i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:t.tempLable.genreName+":",prop:"name"}},[i("el-input",{attrs:{disabled:!0},model:{value:t.temp.genreName,callback:function(e){t.$set(t.temp,"genreName",e)},expression:"temp.genreName"}})],1),t._v(" "),i("el-form-item",{attrs:{label:t.tempLable.code+":",prop:"code"}},[i("el-input",{attrs:{disabled:!0},model:{value:t.temp.code,callback:function(e){t.$set(t.temp,"code",e)},expression:"temp.code"}})],1),t._v(" "),i("el-form-item",{attrs:{label:t.tempLable.name+":",prop:"name"}},[i("el-input",{model:{value:t.temp.name,callback:function(e){t.$set(t.temp,"name",e)},expression:"temp.name"}})],1)],1)],1),t._v(" "),i("el-row",[i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:t.tempLable.spec+":",prop:"spec"}},[i("el-input",{model:{value:t.temp.spec,callback:function(e){t.$set(t.temp,"spec",e)},expression:"temp.spec"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:t.tempLable.typeName+":",prop:"typeName"}},[i("base-input-select",{attrs:{data:t.productTypeData.data},on:{callback:t.productTypeSelect},model:{value:t.productTypeData.defaultSelected,callback:function(e){t.$set(t.productTypeData,"defaultSelected",e)},expression:"productTypeData.defaultSelected"}})],1)],1)],1),t._v(" "),i("el-row",[i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:t.tempLable.stockCount+":",prop:"stockCount"}},[i("el-input",{attrs:{disabled:!0},model:{value:t.temp.stockCount,callback:function(e){t.$set(t.temp,"stockCount",e)},expression:"temp.stockCount"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:t.tempLable.validityDays+":",prop:"validityDays"}},[i("el-input",{model:{value:t.temp.validityDays,callback:function(e){t.$set(t.temp,"validityDays",t._n(e))},expression:"temp.validityDays"}})],1)],1)],1),t._v(" "),i("el-row",[i("el-col",{attrs:{span:24}},[i("el-form-item",{attrs:{label:t.tempLable.remark+":",prop:"remark"}},[i("el-input",{staticStyle:{width:"450px"},attrs:{type:"textarea",rows:"2"},model:{value:t.temp.remark,callback:function(e){t.$set(t.temp,"remark",e)},expression:"temp.remark"}})],1)],1)],1),t._v(" "),i("el-row",[i("div",{staticStyle:{height:"200px"}},[i("dyna-form",{ref:"dynaForm",attrs:{formTemp:t.formTemp,props:{key:"name",value:"value"}},on:{"sent-list":t.formListResult}})],1)])],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)])},[],!1,null,"16ad87f2",null);l.options.__file="dialogEdit.vue";e.default=l.exports},apiY:function(t,e,i){"use strict";var a=i("wuKC");i.n(a).a},vjeH:function(t,e,i){},wuKC:function(t,e,i){}}]);