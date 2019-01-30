(window.webpackJsonp=window.webpackJsonp||[]).push([["y62p"],{y62p:function(e,t,i){"use strict";i.r(t);i("rE2o"),i("ioFf"),i("rGqo"),i("KKXr");var a=i("K3g7");function n(e){return(n="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var l={components:{},name:"dialog-add",props:["initData","visible"],data:function(){return{rangeType:"number",numberStart:1,numberEnd:1,letterStart:"A",letterEnd:"A",letterValues:"A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z",letterStartOptions:[],letterEndOptions:[],isShowNumber:!0,isShowLetter:!1,dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{},rules:{name:[{required:!0,message:"请填写货位名称",trigger:"change"}]},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"",fullscreen:!1,tempLable:null},formTemp:[]}},created:function(){var e=this;null!=this.letterValues&&0!=this.letterValues.trim().length&&this.letterValues.split(",").forEach(function(t){if(null!=t&&t.trim().length>0){var i={value:"",label:""};i.value=t,i.label=t,e.letterStartOptions.push(i),e.letterEndOptions.push(i)}})},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var e=n(this.initData.width);if("number"===e)return this.initData.width+"px";if("string"===e){var t=parseInt(this.initData.width);return t?t>100?"100%":t+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){var e=this;this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},dialogClose:function(e){this.$emit("close-dialog",e||{})},radioChange:function(){this.isShowNumber=!1,this.isShowLetter=!1,this.numberStart=1,this.numberEnd=1,this.letterStart="A",this.letterEnd="A","number"==this.rangeType?this.isShowNumber=!0:"letter"==this.rangeType&&(this.isShowLetter=!0)},save:function(){var e=this;if(null!=this.initData.nodeId&&0!=this.initData.nodeId.trim().length){var t="",i="",n=-1,l=-1;"number"==this.rangeType?(t=this.numberStart,i=this.numberEnd,n=t,l=i):"letter"==this.rangeType&&(t=this.letterStart,i=this.letterEnd,n=t.charCodeAt(),l=i.charCodeAt()),-1!="number,letter".indexOf(this.rangeType)&&l<n?this.$message({type:"warning",duration:5e3,showClose:!0,message:"输入范围参数错误，(结束范围)必须小于等于(起始范围)"}):-1!="number,letter".indexOf(this.rangeType)?this.$refs.submitForm.validate(function(n){n&&(e.dialogLoading=!0,e.temp.start=t,e.temp.end=i,e.temp.pid=e.initData.nodeId,Object(a.addWarehousePositionByRange)(e.temp).then(function(t){e.dialogLoading=!1,0===t.code&&(e.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),e.isVisible=!1,e.dialogClose({resState:"ok"}))}).catch(function(t){e.dialogLoading=!1}))}):-1!="name".indexOf(this.rangeType)&&this.$refs.submitForm.validate(function(t){t&&(e.dialogLoading=!0,e.temp.pid=e.initData.nodeId,Object(a.addWarehousePosition)(e.temp).then(function(t){e.dialogLoading=!1,0===t.code&&(e.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),e.isVisible=!1,e.dialogClose({resState:"ok"}))}).catch(function(t){e.dialogLoading=!1}))})}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请在左边仓库树选择一个节点！"})},closeDialog:function(e){this.showDialog=!1}}},o=i("KHd+"),r=Object(o.a)(l,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.initData.title?e.initData.title:"新增",visible:e.isVisible,"append-to-body":e.inDialog,"close-on-click-modal":e.onModal,"close-on-press-escape":e.onEscape,fullscreen:e.fullscreen,width:"500px"},on:{"update:visible":function(t){e.isVisible=t},open:e.dialogOpen,close:e.dialogClose}},[e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.inLinVisible},on:{"close-dialog":e.closeDialog}}):e._e(),e._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}],staticStyle:{height:"300px"}},[i("el-form",{ref:"submitForm",attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"120px"}},[i("el-row",{staticStyle:{margin:"30px 120px"}},[i("el-radio-group",{on:{change:e.radioChange},model:{value:e.rangeType,callback:function(t){e.rangeType=t},expression:"rangeType"}},[i("el-radio",{attrs:{label:"number"}},[e._v("数字")]),e._v(" "),i("el-radio",{attrs:{label:"letter"}},[e._v("字母")]),e._v(" "),i("el-radio",{attrs:{label:"name"}},[e._v("自定义")])],1)],1),e._v(" "),i("div",{staticStyle:{height:"200px"}},[i("el-row",{directives:[{name:"show",rawName:"v-show",value:e.isShowNumber,expression:"isShowNumber"}]},[i("el-form-item",{attrs:{label:"序号范围："}},[i("el-input-number",{attrs:{size:"mini",min:1,max:100},model:{value:e.numberStart,callback:function(t){e.numberStart=t},expression:"numberStart"}}),e._v(" -\n            "),i("el-input-number",{attrs:{size:"mini",min:1,max:100},model:{value:e.numberEnd,callback:function(t){e.numberEnd=t},expression:"numberEnd"}})],1)],1),e._v(" "),i("el-row",{directives:[{name:"show",rawName:"v-show",value:e.isShowLetter,expression:"isShowLetter"}]},[i("el-form-item",{attrs:{label:"起始范围:",prop:"start"}},[i("el-select",{attrs:{placeholder:"请选择"},model:{value:e.letterStart,callback:function(t){e.letterStart=t},expression:"letterStart"}},e._l(e.letterStartOptions,function(e){return i("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})}),1)],1),e._v(" "),i("el-form-item",{attrs:{label:"结束范围:",prop:"end"}},[i("el-select",{attrs:{placeholder:"请选择"},model:{value:e.letterEnd,callback:function(t){e.letterEnd=t},expression:"letterEnd"}},e._l(e.letterEndOptions,function(e){return i("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})}),1)],1)],1),e._v(" "),i("el-form-item",{attrs:{label:"货位名称：",prop:"name"}},[i("el-input",{staticStyle:{width:"200px"},model:{value:e.temp.name,callback:function(t){e.$set(e.temp,"name",t)},expression:"temp.name"}})],1)],1)],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("保存")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)],1)],1)},[],!1,null,null,null);r.options.__file="warehousePositionRangeAdd.vue";t.default=r.exports}}]);