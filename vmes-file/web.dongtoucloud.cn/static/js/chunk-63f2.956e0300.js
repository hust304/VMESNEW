(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-63f2"],{"/rIY":function(e,t,a){"use strict";a.r(t);a("rE2o"),a("ioFf");var i=a("9rC1");function l(e){return(l="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var o={name:"dialog-add",props:["initData","visible"],data:function(){return{dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{},rules:{name:[{required:!0,message:"请填写名称",trigger:"change"}]},typeData:{},customerTypeData:{data:{selectUrl:"/system/dictionary/getDictionarys",selectParm:{dictionaryKey:"customerType",isglobal:"0",isNeetOneLayer:"true"}},defaultSelected:[]},supplierTypeData:{data:{selectUrl:"/system/dictionary/getDictionarys",selectParm:{dictionaryKey:"supplierType",isglobal:"0",isNeetOneLayer:"true"}},defaultSelected:[]},provinceData:{data:{selectUrl:"/system/dictionary/treeDictionarys",selectParm:{dictionaryKey:"area",cascade:"true"}},defaultSelected:[]},openDialogName:"",showDialog:!1,inLinVisible:!1}},created:function(){this.initData.temp&&(this.temp=this.initData.temp),this.initData.tempLable&&(this.tempLable=this.initData.tempLable)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=l(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{typeSelect:function(e){e[0]?(this.temp.type=e[0],this.typeData.defaultSelected=[e[0]]):(this.temp.type=[],this.typeData.defaultSelected=[])},provinceSelect:function(e){e&&e.length>0?(this.temp.province=e[e.length-1],this.provinceData.defaultSelected=e):(this.temp.province=[],this.provinceData.defaultSelected=[])},dialogOpen:function(){var e=this,t=this.temp.genre;"df7cb67fca4148bc9632c908e4a7fdea"==t?(this.typeData=this.customerTypeData,this.temp.type=this.typeData.defaultSelected[0]):"49c0a7ebcb4c4175bd5195837a6a9a13"==t&&(this.typeData=this.supplierTypeData,this.temp.type=this.typeData.defaultSelected[0]),this.temp.province=this.provinceData.defaultSelected[0],this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},dialogClose:function(e){this.$emit("close-dialog",e||{})},save:function(){var e=this,t=this;this.$refs.submitForm.validate(function(a){a&&(t.dialogLoading=!0,Object(i.addCustomer)(t.temp).then(function(a){t.dialogLoading=!1,0===a.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok",genre:e.temp.genre}))}).catch(function(e){console.log(e),t.dialogLoading=!1}))})},closeDialog:function(e){this.showDialog=!1}}},n=(a("u845"),a("KHd+")),s=Object(n.a)(o,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"新增",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:e.dialogWidth},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?a(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[a("el-form",{ref:"submitForm",staticStyle:{width:"80%","padding-top":"10px"},attrs:{rules:e.rules,model:e.temp,"label-position":"left","label-width":"80px"}},[a("el-form-item",{attrs:{label:e.tempLable.genreName+":",prop:"genreName"}},[a("el-input",{attrs:{disabled:!0},model:{value:e.temp.genreName,callback:function(t){e.$set(e.temp,"genreName",t)},expression:"temp.genreName"}})],1),e._v(" "),a("el-form-item",{attrs:{label:e.tempLable.name+":",prop:"name"}},[a("el-input",{model:{value:e.temp.name,callback:function(t){e.$set(e.temp,"name",t)},expression:"temp.name"}})],1),e._v(" "),a("el-form-item",{attrs:{label:e.tempLable.typeName+":",prop:"typeName"}},[a("base-input-select",{staticStyle:{width:"240px"},attrs:{data:e.typeData.data},on:{callback:e.typeSelect},model:{value:e.typeData.defaultSelected,callback:function(t){e.$set(e.typeData,"defaultSelected",t)},expression:"typeData.defaultSelected"}})],1),e._v(" "),a("el-form-item",{attrs:{label:e.tempLable.provinceName+":",prop:"provinceName"}},[a("base-input-select",{staticStyle:{width:"240px"},attrs:{data:e.provinceData.data},on:{callback:e.provinceSelect},model:{value:e.provinceData.defaultSelected,callback:function(t){e.$set(e.provinceData,"defaultSelected",t)},expression:"provinceData.defaultSelected"}})],1),e._v(" "),a("el-form-item",{attrs:{label:e.tempLable.remark+":",prop:"remark"}},[a("el-input",{attrs:{type:"textarea",rows:"2"},model:{value:e.temp.remark,callback:function(t){e.$set(e.temp,"remark",t)},expression:"temp.remark"}})],1)],1),e._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),a("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,"6102d013",null);s.options.__file="dialogAdd.vue";t.default=s.exports},"a/9l":function(e,t,a){},u845:function(e,t,a){"use strict";var i=a("a/9l");a.n(i).a}}]);