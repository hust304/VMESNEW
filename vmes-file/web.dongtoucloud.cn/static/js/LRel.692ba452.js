(window.webpackJsonp=window.webpackJsonp||[]).push([["LRel"],{LRel:function(e,t,i){"use strict";i.r(t);i("rE2o"),i("ioFf"),i("f3/d");var a=i("HhAy");function o(e){return(o="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var n={name:"dialog-add",props:["initData","visible"],components:{},data:function(){return{dialogLoading:!0,isVisible:!1,inDialog:!0,selectTree:{},temp:{},tempLable:{},tempNotEditable:{deptName:!0},tempShow:{deptName:!0},rules:{name:[{required:!0,trigger:"change",message:"请选择货品"}],ratio:[{required:!0,trigger:"change",validator:function(e,t,i){console.info("value:",t),t?/^[0-9]+(.[0-9]{1,2})?$/.test(t)?t<=0?i(new Error("用料比例必须大于零！")):i():i(new Error("请填写正确的用料比例，只能填写数字！")):i(new Error("用料比例必须大于零！"))}}]},optionData:{showDialog:!1,visible:!1,dialog:{data:{isSingle:!0,title:"选择货品",treeUrl:"/system/dictionary/treeDictionarys",treeParm:{dictionaryKey:"productGenre"},tableUrl:"/base/product/listPageProducts",tableParm:{fieldCode:"code,name,spec,genreName,unitName,remark",pathId:this.initData.selectTree.pathId},temp:{}},dialogName:"dialogTreeOption"}}}},created:function(){this.initData.selectTree&&(this.selectTree=this.initData.selectTree),this.initData.temp&&(this.temp=this.initData.temp,this.temp.isdefault="1",this.temp.ratio&&(this.temp.ratio=this.temp.ratio.substring(2))),this.initData.tempLable&&(this.tempLable=this.initData.tempLable)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=o(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},dialogClose:function(e){this.$emit("close-dialog",e||{})},optionSelect:function(e){this.temp=JSON.parse(JSON.stringify(this.temp)),e[0]&&(this.temp.prodId=e[0].id,this.temp.name=e[0].name,this.temp.genreName=e[0].genreName,this.temp.unitName=e[0].unitName,this.temp.typeName=e[0].typeName,this.temp.spec=e[0].spec)},save:function(){var e=this;this.$refs.submitForm.validate(function(t){t&&(e.dialogLoading=!0,Object(a.updateBomTree)(e.temp).then(function(t){e.dialogLoading=!1,0===t.code&&(e.$notify({title:"成功",message:"修改成功",type:"success",duration:2e3}),e.isVisible=!1,e.dialogClose({resState:"ok"}))}).catch(function(t){console.log(t),e.dialogLoading=!1}))})}}},l=i("KHd+"),s=Object(l.a)(n,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"新增",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"500px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{width:"400px","padding-top":"10px"},attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"120px"}},[i("el-form-item",{attrs:{label:"上级名称:"}},[i("el-input",{attrs:{disabled:!0},model:{value:e.selectTree.name,callback:function(t){e.$set(e.selectTree,"name",t)},expression:"selectTree.name"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"选择货品:",prop:"name"}},[i("base-input-option",{attrs:{dialog:e.optionData.dialog},on:{callback:e.optionSelect},model:{value:e.temp.name,callback:function(t){e.$set(e.temp,"name",t)},expression:"temp.name"}})],1),e._v(" "),i("el-form-item",{attrs:{label:e.tempLable.spec+":",prop:"spec"}},[i("el-input",{attrs:{disabled:!0},model:{value:e.temp.spec,callback:function(t){e.$set(e.temp,"spec",t)},expression:"temp.spec"}})],1),e._v(" "),i("el-form-item",{attrs:{label:e.tempLable.genreName+":",prop:"genreName"}},[i("el-input",{attrs:{disabled:!0},model:{value:e.temp.genreName,callback:function(t){e.$set(e.temp,"genreName",t)},expression:"temp.genreName"}})],1),e._v(" "),i("el-form-item",{attrs:{label:e.tempLable.typeName+":",prop:"typeName"}},[i("el-input",{attrs:{disabled:!0},model:{value:e.temp.typeName,callback:function(t){e.$set(e.temp,"typeName",t)},expression:"temp.typeName"}})],1),e._v(" "),i("el-form-item",{attrs:{label:e.tempLable.unitName+":",prop:"unitName"}},[i("el-input",{attrs:{disabled:!0},model:{value:e.temp.unitName,callback:function(t){e.$set(e.temp,"unitName",t)},expression:"temp.unitName"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"单件用量:",prop:"ratio"}},[i("el-input",{model:{value:e.temp.ratio,callback:function(t){e.$set(e.temp,"ratio",t)},expression:"temp.ratio"}})],1)],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)])},[],!1,null,null,null);s.options.__file="dialogTreeEdit.vue";t.default=s.exports}}]);