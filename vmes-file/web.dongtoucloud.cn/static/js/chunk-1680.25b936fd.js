(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-1680"],{"3Er3":function(t,e,i){"use strict";i.r(e);i("rE2o"),i("ioFf");var a=i("K3g7");function n(t){return(n="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var o={components:{DynaForm:i("NaOS").a},name:"dialog-add",props:["initData","visible"],data:function(){var t=this;return{dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{},rules:{name:[{required:!0,message:"请填写仓库名称",trigger:"change"}],entityTypeName:[{required:!0,trigger:"change",validator:function(e,i,a){t.entityTypeData.defaultSelected.length<=0?a(new Error("请选择仓库类型")):a()}}]},entityTypeData:{data:{selectUrl:"/system/dictionary/getDictionarys",selectParm:{dictionaryKey:"warehouseType",isglobal:"1"}},defaultSelected:[]},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",fullscreen:!1,tempLable:null},formTemp:[]}},created:function(){this.initData.temp&&(this.temp=this.initData.temp),this.initData.tempLable&&(this.tempLable=this.initData.tempLable)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=n(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{entityTypeSelect:function(t){t[0]?(this.temp.entityType=t[0],this.entityTypeData.defaultSelected=[t[0]]):(this.temp.entityType=[],this.entityTypeData.defaultSelected=[])},dialogOpen:function(){var t=this;this.entityTypeData.defaultSelected=[],this.entityTypeData.defaultSelected.push(this.temp.entityType),this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},save:function(){var t=this;this.$refs.submitForm.validate(function(e){e&&(t.dialogLoading=!0,Object(a.updateWarehouseByEntity)(t.temp).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){t.dialogLoading=!1}))})},closeDialog:function(t){this.showDialog=!1}}},l=(i("hbbN"),i("KHd+")),s=Object(l.a)(o,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"新增",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"400px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}],staticStyle:{"padding-top":"10px"}},[i("el-form",{ref:"submitForm",staticStyle:{width:"570px",margin:"10px auto"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[i("el-form-item",{attrs:{label:"仓库性质:"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{value:"实体库",readonly:!0}})],1),t._v(" "),i("el-form-item",{attrs:{label:"仓库名称:",prop:"name"}},[i("el-input",{staticStyle:{width:"200px"},model:{value:t.temp.name,callback:function(e){t.$set(t.temp,"name",e)},expression:"temp.name"}})],1),t._v(" "),i("el-form-item",{attrs:{label:t.tempLable.entityTypeName+":",prop:"entityTypeName"}},[i("base-input-select",{attrs:{data:t.entityTypeData.data},on:{callback:t.entityTypeSelect},model:{value:t.entityTypeData.defaultSelected,callback:function(e){t.$set(t.entityTypeData,"defaultSelected",e)},expression:"entityTypeData.defaultSelected"}})],1)],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,"02ac8d4a",null);s.options.__file="warehouseEntityEdit.vue";e.default=s.exports},"8N7a":function(t,e,i){},"9O1b":function(t,e,i){"use strict";var a=i("8N7a");i.n(a).a},NaOS:function(t,e,i){"use strict";i("rGqo");function a(t,e,i){return e in t?Object.defineProperty(t,e,{value:i,enumerable:!0,configurable:!0,writable:!0}):t[e]=i,t}var n={components:{},name:"dyna-form",props:{config:{type:Object,default:function(){return{}}},formTemp:{type:Array,default:function(){return[]}},props:{type:Object,default:function(){return{key:"key",value:"value"}}}},data:function(){var t=this;return{btnsBoxHeight:0,addFormData:[],isVisible:!1,saveBtnState:!0,tempFormList:[{key:"",value:""}],itemRule:[{validator:function(e,i,a){""===i?(t.saveBtnState=!0,a(new Error("请定义属性名称"))):t.deDuplication(i)?(t.saveBtnState=!0,a(new Error("有重复的属性名称"))):a()},trigger:"blur"}],formData:[]}},created:function(){this.formData=this.renameAttr(this.formTemp,!0)},mounted:function(){this.$nextTick(function(){this.btnsBoxHeight=this.hideBtn?this.$refs.btnsBox.clientHeight:0})},computed:{hideBtn:function(){return!this.config.hideBtn},formList:function(){return this.formData.concat(this.addFormData)},onModal:function(){return!1},onEscape:function(){return!1}},methods:{renameAttr:function(t,e){if("key"===this.props.key&&"value"===this.props.value)return t;var i=this.props,n=i.key,o=i.value,l=[];return e?(t.forEach(function(t,e){l.push({key:t[n||"key"],value:t[o||"value"]})}),l):(this.formList.forEach(function(t,e){var i;l.push((a(i={},n||"key",t.key),a(i,o||"value",t.value),i))}),l)},addAttr:function(){this.tempFormList=[{key:"",value:""}],this.isVisible=!0},removeDomain:function(t,e){var i=this,a=!0;this.formData.forEach(function(e,n){e.key===t.key&&(a=!1,i.formData.splice(n,1))}),a&&this.addFormData.forEach(function(e,a){e.key===t.key&&i.addFormData.splice(a,1)})},dialogOpen:function(){var t=this;this.saveBtnState=!0,this.$nextTick(function(){t.tempFormList.forEach(function(e,i){t.$refs["tempForm"+i][0].clearValidate()})})},getFormList:function(){this.$emit("sent-list",this.renameAttr(this.formList))},save:function(){this.addFormData=this.addFormData.concat(this.tempFormList),this.isVisible=!1},addContent:function(){this.tempFormList.push({key:"",value:""}),this.saveBtnState=!0},deleteContent:function(t,e){this.tempFormList.splice(e,1),this.switchSaveBtnState()},deDuplication:function(t){var e=0;return this.tempFormList.forEach(function(i){i.key===t&&e++}),this.formList.forEach(function(i){i.key===t&&e++}),1!==e},checkInput:function(){this.switchSaveBtnState()},switchSaveBtnState:function(){var t=this;this.$nextTick(function(){var e=0,i=!0;t.tempFormList.forEach(function(a,n){i?t.$refs["tempForm"+n][0].validate(function(t){t||(e++,i=!1)}):t.$refs["tempForm"+n][0].validate(function(t){})}),t.saveBtnState=!t.tempFormList.length||!!e})}}},o=(i("9O1b"),i("KHd+")),l=Object(o.a)(n,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"dynaForm",staticStyle:{height:"100%",position:"relative","box-sizing":"border-box"},style:{paddingTop:t.btnsBoxHeight+"px"}},[t.hideBtn?i("div",{ref:"btnsBox",staticClass:"dynaFormBtn",staticStyle:{position:"absolute",top:"0",right:"0"}},[i("el-button",{attrs:{type:"text",size:"mini",icon:"el-icon-plus"},on:{click:t.addAttr}},[t._v("自定义属性")])],1):t._e(),t._v(" "),i("div",{staticClass:"formBox",staticStyle:{height:"100%","overflow-y":"auto"}},[i("el-form",{ref:"resultForm",staticStyle:{padding:"5px"},attrs:{"label-position":"left","label-width":"75px"}},t._l(t.formList,function(e,a){return i("el-form-item",{key:e.key,attrs:{label:e.key}},[i("el-input",{staticStyle:{width:"calc(100% - 27px)"},attrs:{placeholder:"请输入",clearable:""},model:{value:e.value,callback:function(i){t.$set(e,"value",i)},expression:"item.value"}}),i("el-button",{staticStyle:{padding:"5px"},attrs:{type:"text",icon:"el-icon-remove",title:"删除该项"},on:{click:function(i){i.preventDefault(),t.removeDomain(e,a)}}})],1)}),1)],1),t._v(" "),i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:"自定义属性",visible:t.isVisible,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,width:"400px","append-to-body":""},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen}},[i("div",{staticClass:"addContent",staticStyle:{"box-sizing":"border-box",padding:"5px 10px"}},[i("div",[t._l(t.tempFormList,function(e,a){return[i("el-row",{staticStyle:{position:"relative",border:"1px solid #E4E4E4","border-radius":"4px","margin-bottom":"10px"}},[i("el-form",{ref:"tempForm"+a,refInFor:!0,staticStyle:{width:"90%",padding:"5px"},attrs:{model:e,"label-position":"left","label-width":"75px"}},[i("el-form-item",{staticStyle:{"margin-bottom":"20px"},attrs:{label:"属性名称:",prop:"key",rules:t.itemRule}},[i("el-input",{attrs:{placeholder:"请输入属性名",clearable:""},on:{blur:function(i){t.checkInput(e,a)}},model:{value:e.key,callback:function(i){t.$set(e,"key",i)},expression:"item.key"}})],1),t._v(" "),i("el-form-item",{staticStyle:{"margin-bottom":"0"},attrs:{label:"属性值:"}},[i("el-input",{attrs:{placeholder:"请输入属性值",clearable:""},model:{value:e.value,callback:function(i){t.$set(e,"value",i)},expression:"item.value"}})],1)],1),t._v(" "),i("div",{staticStyle:{position:"absolute",right:"8px",top:"50%",transform:"translate(0,-50%)"}},[i("el-button",{staticStyle:{padding:"5px"},attrs:{type:"text",icon:"el-icon-remove",title:"删除该项"},on:{click:function(i){t.deleteContent(e,a)}}})],1)],1)]})],2),t._v(" "),i("div",{ref:"dialogBtn",staticStyle:{"text-align":"center"}},[i("el-button",{staticStyle:{padding:"5px",width:"100%",border:"1px dashed #E4E4E4"},attrs:{type:"text",size:"medium",icon:"el-icon-plus"},on:{click:t.addContent}},[t._v("新增属性")])],1)]),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary",disabled:t.saveBtnState},on:{click:t.save}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)])],1)},[],!1,null,null,null);l.options.__file="index.vue";e.a=l.exports},hbbN:function(t,e,i){"use strict";var a=i("ifC5");i.n(a).a},ifC5:function(t,e,i){}}]);