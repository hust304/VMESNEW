(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-564a2"],{WBFp:function(e,t,i){"use strict";i.r(t);i("rE2o"),i("ioFf");var a=i("9rC1");function l(e){return(l="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var s={name:"dialog-edit",props:["initData","visible"],data:function(){return{dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{},rules:{name:[{required:!0,message:"请填写名称",trigger:"change"}]},typeData:{},customerTypeData:{data:{selectUrl:"/system/dictionary/getDictionarys",selectParm:{dictionaryKey:"customerType",isglobal:"0",isNeetOneLayer:"true"}},defaultSelected:[]},supplierTypeData:{data:{selectUrl:"/system/dictionary/getDictionarys",selectParm:{dictionaryKey:"supplierType",isglobal:"0",isNeetOneLayer:"true"}},defaultSelected:[]},provinceData:{data:{selectUrl:"/system/dictionary/treeDictionarys",selectParm:{dictionaryKey:"area",cascade:"true"}},defaultSelected:[]}}},created:function(){this.initData.temp&&(this.temp=this.initData.temp),this.initData.tempLable&&(this.tempLable=this.initData.tempLable)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=l(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]}},methods:{typeSelect:function(e){e[0]?(this.temp.type=e[0],this.typeData.defaultSelected=[e[0]]):(this.temp.type=[],this.typeData.defaultSelected=[])},provinceSelect:function(e){e&&e.length>0?(this.temp.province=e[e.length-1],this.provinceData.defaultSelected=e):(this.temp.province=[],this.provinceData.defaultSelected=[])},dialogOpen:function(){var e=this,t=this.temp.genre;"df7cb67fca4148bc9632c908e4a7fdea"==t?this.typeData=this.customerTypeData:"49c0a7ebcb4c4175bd5195837a6a9a13"==t&&(this.typeData=this.supplierTypeData),this.typeData.defaultSelected=[],this.typeData.defaultSelected.push(this.temp.type),this.provinceData.defaultSelected=[],this.temp.id1&&this.provinceData.defaultSelected.push(this.temp.id1),this.temp.id2&&this.provinceData.defaultSelected.push(this.temp.id2),this.temp.id3&&this.provinceData.defaultSelected.push(this.temp.id3),this.temp.id4&&this.provinceData.defaultSelected.push(this.temp.id4),this.temp.id5&&this.provinceData.defaultSelected.push(this.temp.id5),this.temp.id6&&this.provinceData.defaultSelected.push(this.temp.id6),this.temp.province&&this.provinceData.defaultSelected.push(this.temp.province),this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},dialogClose:function(e){this.$emit("close-dialog",e||{})},save:function(){var e=this;e.$refs.submitForm.validate(function(t){t&&(e.dialogLoading=!0,Object(a.updateCustomer)(e.temp).then(function(t){e.dialogLoading=!1,0===t.code&&(e.$notify({title:"成功",message:"修改成功",type:"success",duration:2e3}),e.isVisible=!1,e.dialogClose({resState:"ok"}))}).catch(function(t){e.dialogLoading=!1}))})}}},o=(i("Wu2+"),i("KHd+")),n=Object(o.a)(s,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"编辑",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:e.dialogWidth},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{width:"80%","padding-top":"10px"},attrs:{rules:e.rules,model:e.temp,"label-position":"left","label-width":"80px"}},[i("el-form-item",{attrs:{label:e.tempLable.code+":",prop:"code"}},[i("el-input",{attrs:{disabled:!0},model:{value:e.temp.code,callback:function(t){e.$set(e.temp,"code",t)},expression:"temp.code"}})],1),e._v(" "),i("el-form-item",{attrs:{label:e.tempLable.name+":",prop:"name"}},[i("el-input",{model:{value:e.temp.name,callback:function(t){e.$set(e.temp,"name",t)},expression:"temp.name"}})],1),e._v(" "),i("el-form-item",{attrs:{label:e.tempLable.typeName+":",prop:"typeName"}},[i("base-input-select",{staticStyle:{width:"240px"},attrs:{data:e.typeData.data},on:{callback:e.typeSelect},model:{value:e.typeData.defaultSelected,callback:function(t){e.$set(e.typeData,"defaultSelected",t)},expression:"typeData.defaultSelected"}})],1),e._v(" "),i("el-form-item",{attrs:{label:e.tempLable.provinceName+":",prop:"provinceName"}},[i("base-input-select",{staticStyle:{width:"240px"},attrs:{data:e.provinceData.data},on:{callback:e.provinceSelect},model:{value:e.provinceData.defaultSelected,callback:function(t){e.$set(e.provinceData,"defaultSelected",t)},expression:"provinceData.defaultSelected"}})],1),e._v(" "),i("el-form-item",{attrs:{label:e.tempLable.remark+":",prop:"remark"}},[i("el-input",{attrs:{type:"textarea",rows:"2"},model:{value:e.temp.remark,callback:function(t){e.$set(e.temp,"remark",t)},expression:"temp.remark"}})],1)],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)])},[],!1,null,"5d55fd20",null);n.options.__file="dialogEdit.vue";t.default=n.exports},WirT:function(e,t,i){},"Wu2+":function(e,t,i){"use strict";var a=i("WirT");i.n(a).a}}]);