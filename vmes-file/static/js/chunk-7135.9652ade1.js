(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-7135"],{Ib18:function(t,e,i){},JfNE:function(t,e,i){"use strict";var a=i("Ib18");i.n(a).a},"V/0Z":function(t,e,i){"use strict";i.d(e,"d",function(){return o}),i.d(e,"a",function(){return n}),i.d(e,"e",function(){return r}),i.d(e,"f",function(){return l}),i.d(e,"g",function(){return s}),i.d(e,"b",function(){return d}),i.d(e,"c",function(){return u});var a=i("t3Un");function o(t){return Object(a.a)({url:"/base/bom/listPageBoms",method:"post",data:t})}function n(t){return Object(a.a)({url:"/base/bom/addBom",method:"post",data:t})}function r(t){return Object(a.a)({url:"/base/bom/updateBom",method:"post",data:t})}function l(t,e){return Object(a.a)({url:"/base/bom/update",method:"post",data:{id:t,isdisable:e}})}function s(t,e,i){return Object(a.a)({url:"/base/bom/updateIsDefaultBom",method:"post",data:{id:t,isdefault:e,prodId:i}})}function d(t){return Object(a.a)({url:"/base/bom/deleteBoms",method:"post",data:{ids:t}})}function u(t){return Object(a.a)({url:"/base/bom/exportExcelBoms",method:"post",responseType:"blob",data:{ids:t}})}},odo6:function(t,e,i){"use strict";i.r(e);i("rE2o"),i("ioFf"),i("f3/d");var a=i("V/0Z");function o(t){return(o="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var n={name:"dialog-add",props:["initData","visible"],components:{},data:function(){return{dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{deptName:!0},tempShow:{deptName:!0},rules:{name:[{required:!0,message:"请填写Bom名称",trigger:"change"}],prodName:[(t={required:!0,trigger:"change",message:"请选择货品"},e="trigger",i="change",e in t?Object.defineProperty(t,e,{value:i,enumerable:!0,configurable:!0,writable:!0}):t[e]=i,t)]},optionData:{showDialog:!1,visible:!1,dialog:{data:{isSingle:!0,title:"选择货品",treeUrl:"/system/dictionary/treeDictionarys",treeParm:{dictionaryKey:"productGenre"},tableUrl:"/base/product/listPageProducts",tableParm:{},temp:{}},dialogName:"dialogTreeOption"}}};var t,e,i},created:function(){this.initData.temp&&(this.temp=this.initData.temp),this.temp.isdefault="1",this.initData.tempLable&&(this.tempLable=this.initData.tempLable)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=o(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},optionSelect:function(t){this.temp=JSON.parse(JSON.stringify(this.temp)),t[0]&&(this.temp.prodId=t[0].id,this.temp.prodName=t[0].name)},save:function(){var t=this;this.$refs.submitForm.validate(function(e){e&&(t.dialogLoading=!0,Object(a.a)(t.temp).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){console.log(e),t.dialogLoading=!1}))})}}},r=(i("JfNE"),i("KHd+")),l=Object(r.a)(n,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"新增",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"500px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{width:"400px",margin:"10px auto"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[i("el-form-item",{attrs:{label:t.tempLable.name+":",prop:"name"}},[i("el-input",{model:{value:t.temp.name,callback:function(e){t.$set(t.temp,"name",e)},expression:"temp.name"}})],1),t._v(" "),i("el-form-item",{attrs:{label:t.tempLable.prodName+":",prop:"prodName"}},[i("base-input-option",{attrs:{dialog:t.optionData.dialog},on:{callback:t.optionSelect},model:{value:t.temp.prodName,callback:function(e){t.$set(t.temp,"prodName",e)},expression:"temp.prodName"}})],1),t._v(" "),i("el-form-item",{attrs:{label:t.tempLable.isdefault+":",prop:"isdefault"}},[i("el-switch",{attrs:{"active-value":"1","inactive-value":"0"},model:{value:t.temp.isdefault,callback:function(e){t.$set(t.temp,"isdefault",e)},expression:"temp.isdefault"}})],1),t._v(" "),i("el-form-item",{attrs:{label:t.tempLable.remark+":",prop:"remark"}},[i("el-input",{model:{value:t.temp.remark,callback:function(e){t.$set(t.temp,"remark",e)},expression:"temp.remark"}})],1)],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)])},[],!1,null,"ed28ed2e",null);l.options.__file="dialogAdd.vue";e.default=l.exports}}]);