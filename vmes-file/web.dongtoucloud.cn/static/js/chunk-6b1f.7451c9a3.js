(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-6b1f","chunk-2eb5","chunk-52cf"],{"9Edw":function(t,e,i){},Ck00:function(t,e,i){"use strict";var a={name:"formula-dialog",props:["visible","state"],components:{formulaEdit:i("eIWk").a},data:function(){return{innerVisible:!1,formulaStr:""}},computed:{setState:function(){return this.state}},watch:{},methods:{formula:function(t){this.formulaStr=t,this.innerVisible=!1},dialogClose:function(){this.$emit("close-dialog",this.formulaStr)}},created:function(){},mounted:function(){this.innerVisible=this.visible}},n=i("KHd+"),o=Object(n.a)(a,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{width:"650px",title:"公式编辑器",visible:t.innerVisible,"append-to-body":""},on:{"update:visible":function(e){t.innerVisible=e},close:t.dialogClose}},[i("div",{staticStyle:{padding:"10px","text-align":"center"}},[i("formula-edit",{attrs:{state:t.setState},on:{"send-formula":t.formula}})],1)])},[],!1,null,null,null);o.options.__file="dialog.vue";e.a=o.exports},L4vu:function(t,e,i){"use strict";i.r(e);i("rE2o"),i("ioFf");var a=i("a0Xs");function n(t){return(n="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var o={components:{formulaDialog:i("Ck00").a},name:"dialog-edit",props:["initData","visible"],data:function(){var t=this;return{dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{},rules:{pnFormula:[{required:!0,trigger:"change",validator:function(e,i,a){t.temp.pnFormula?a():a(new Error("请填写计量单位转计价单位公式！"))}}],npFormula:[{required:!0,trigger:"change",validator:function(e,i,a){t.temp.npFormula?a():a(new Error("请填写计价单位转计量单位公式！"))}}],punitName:[{required:!0,trigger:"change",validator:function(e,i,a){t.unitData.defaultSelected.length<=0?a(new Error("请选择计价单位")):a()}}]},unitData:{data:{selectUrl:"/system/dictionary/getDictionarys",selectParm:{dictionaryKey:"productUnit",isglobal:"0"}},defaultSelected:[]},formTemp:[],showDialog:!1,visibleState:!1,dialogName:"",formulaState:"",Poption:"",Noption:"",Pprecision:0,Nprecision:0}},created:function(){this.initData.temp&&(this.temp=this.initData.temp),this.initData.tempLable&&(this.tempLable=this.initData.tempLable),"Y"==this.temp.n2pIsScale?this.Poption=1:"N"==this.temp.n2pIsScale?this.Poption=2:this.Poption=1,this.Pprecision=this.temp.n2pDecimalCount,"Y"==this.temp.p2nIsScale?this.Noption=1:"N"==this.temp.p2nIsScale?this.Noption=2:this.Noption=1,this.Nprecision=this.temp.p2nDecimalCount},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=n(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},n2pIsScale:function(){return 1===this.Poption},p2nIsScale:function(){return 1===this.Noption},n2pDecimalCount:function(){return this.Pprecision},p2nDecimalCount:function(){return this.Nprecision}},methods:{closeDialog:function(t){this.visibleState=!1,this.showDialog=!1,t&&("n"===this.formulaState?this.temp.npFormula=t:this.temp.pnFormula=t)},openFormulaEdit:function(t){this.dialogName="formulaDialog",this.showDialog=!0,this.formulaState=t,this.visibleState=!0},dialogOpen:function(){this.unitData.defaultSelected=[this.initData.temp.punit],this.temp.unit=this.initData.temp.punit},unitSelect:function(t){t[0]?(this.temp.unit=t[0],this.unitData.defaultSelected=[t[0]]):(this.temp.unit=[],this.unitData.defaultSelected=[])},dialogClose:function(t){this.$emit("close-dialog",t||{})},save:function(){var t=this,e=this;e.$refs.submitForm.validate(function(i){if(i){e.dialogLoading=!0;var n=e.temp.npFormula,o=e.temp.pnFormula;e.temp.pnFormula=n,e.temp.npFormula=o;var l="N",s=t.n2pIsScale;null!=s&&s&&(l="Y"),e.temp.n2pIsScale=l,e.temp.n2pDecimalCount=t.n2pDecimalCount;var r="N",c=t.p2nIsScale;null!=c&&c&&(r="Y"),e.temp.p2nIsScale=r,e.temp.p2nDecimalCount=t.p2nDecimalCount,Object(a.updateProductUnit)(e.temp).then(function(t){e.dialogLoading=!1,0===t.code&&(e.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),e.isVisible=!1,e.dialogClose({resState:"ok"}))}).catch(function(t){e.dialogLoading=!1})}})}}},l=i("KHd+"),s=Object(l.a)(o,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"编辑",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"620px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{width:"570px","padding-top":"10px"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[i("el-row",[i("el-col",{attrs:{span:12}},[i("el-form-item",{directives:[{name:"show",rawName:"v-show",value:"计价单位"==t.temp.type,expression:"temp.type=='计价单位'"}],attrs:{label:"计量单位:",prop:"unitName"}},[i("el-input",{attrs:{disabled:!0},model:{value:t.temp.unitName,callback:function(e){t.$set(t.temp,"unitName",e)},expression:"temp.unitName"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:t.tempLable.punitName+":",prop:"punitName"}},[i("base-input-select",{attrs:{data:t.unitData.data},on:{callback:t.unitSelect},model:{value:t.unitData.defaultSelected,callback:function(e){t.$set(t.unitData,"defaultSelected",e)},expression:"unitData.defaultSelected"}})],1)],1)],1),t._v(" "),i("el-row",{directives:[{name:"show",rawName:"v-show",value:"计价单位"==t.temp.type,expression:"temp.type=='计价单位'"}]},[i("el-col",{attrs:{span:16}},[i("el-form-item",{attrs:{label:"计量单位转换计价单位(公式):",prop:"pnFormula"}},[i("el-input",{attrs:{type:"textarea",rows:"3",disabled:!0},model:{value:t.temp.pnFormula,callback:function(e){t.$set(t.temp,"pnFormula",e)},expression:"temp.pnFormula"}}),t._v(" "),i("el-button",{attrs:{type:"text",icon:"el-icon-plus"},on:{click:function(e){t.openFormulaEdit("p")}}},[t._v("公式编辑器")])],1)],1),t._v(" "),i("el-col",{staticStyle:{"padding-top":"3px"},attrs:{span:8}},[i("el-radio-group",{staticClass:"resetFormulaRadioStyle",staticStyle:{width:"100%"},model:{value:t.Poption,callback:function(e){t.Poption=e},expression:"Poption"}},[i("el-radio",{staticStyle:{display:"block",width:"100%","margin-left":"0","padding-left":"5px"},attrs:{label:1}},[t._v("需要四舍五入")]),t._v(" "),i("el-radio",{staticStyle:{display:"block",width:"100%","margin-left":"0",height:"28px","line-height":"30px","padding-left":"5px"},attrs:{label:2}},[t._v("无需四舍五入")])],1),t._v(" "),i("div",{staticClass:"resetFormulaRadioInputStyle",staticStyle:{display:"block",width:"100%","margin-left":"0","padding-left":"5px"}},[t._v("\n            保留小数"),i("el-input-number",{attrs:{size:"mini",max:4,min:0},model:{value:t.Pprecision,callback:function(e){t.Pprecision=e},expression:"Pprecision"}}),t._v("位\n          ")],1)],1)],1),t._v(" "),i("el-row",{directives:[{name:"show",rawName:"v-show",value:"计价单位"==t.temp.type,expression:"temp.type=='计价单位'"}]},[i("el-col",{attrs:{span:16}},[i("el-form-item",{attrs:{label:"计价单位转换计量单位(公式):",prop:"npFormula"}},[i("el-input",{attrs:{type:"textarea",rows:"3",disabled:!0},model:{value:t.temp.npFormula,callback:function(e){t.$set(t.temp,"npFormula",e)},expression:"temp.npFormula"}}),t._v(" "),i("el-button",{attrs:{type:"text",icon:"el-icon-plus"},on:{click:function(e){t.openFormulaEdit("n")}}},[t._v("公式编辑器")])],1)],1),t._v(" "),i("el-col",{staticStyle:{"padding-top":"3px"},attrs:{span:8}},[i("el-radio-group",{staticClass:"resetFormulaRadioStyle",staticStyle:{width:"100%"},model:{value:t.Noption,callback:function(e){t.Noption=e},expression:"Noption"}},[i("el-radio",{staticStyle:{display:"block",width:"100%","margin-left":"0","padding-left":"5px"},attrs:{label:1}},[t._v("需要四舍五入")]),t._v(" "),i("el-radio",{staticStyle:{display:"block",width:"100%","margin-left":"0",height:"28px","line-height":"30px","padding-left":"5px"},attrs:{label:2}},[t._v("无需四舍五入")])],1),t._v(" "),i("div",{staticClass:"resetFormulaRadioInputStyle",staticStyle:{display:"block",width:"100%","margin-left":"0","padding-left":"5px"}},[t._v("\n            保留小数"),i("el-input-number",{attrs:{size:"mini",max:4,min:0},model:{value:t.Nprecision,callback:function(e){t.Nprecision=e},expression:"Nprecision"}}),t._v("位\n          ")],1)],1)],1),t._v(" "),i("el-row",[i("el-col",{attrs:{span:24}},[i("el-form-item",{attrs:{label:"备注:",prop:"remark"}},[i("el-input",{staticStyle:{width:"450px"},attrs:{type:"textarea",rows:"2"},model:{value:t.temp.remark,callback:function(e){t.$set(t.temp,"remark",e)},expression:"temp.remark"}})],1)],1)],1)],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1),t._v(" "),t.showDialog?i(t.dialogName,{tag:"component",attrs:{state:t.formulaState,visible:t.visibleState},on:{"close-dialog":t.closeDialog}}):t._e()],1)},[],!1,null,null,null);s.options.__file="dialogUnitEdit.vue";e.default=s.exports},XAWQ:function(t,e,i){"use strict";var a=i("XTNa");i.n(a).a},XTNa:function(t,e,i){},Y29c:function(t,e,i){"use strict";var a=i("9Edw");i.n(a).a},bUBY:function(t,e,i){},dpNl:function(t,e,i){"use strict";i.r(e);i("rE2o"),i("ioFf");var a=i("a0Xs");function n(t){return(n="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var o={components:{formulaDialog:i("Ck00").a},name:"dialog-edit",props:["initData","visible"],data:function(){var t=this;return{dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{},rules:{pnFormula:[{required:!0,trigger:"change",validator:function(e,i,a){t.temp.pnFormula?a():a(new Error("请填写计量单位转计价单位公式！"))}}],npFormula:[{required:!0,trigger:"change",validator:function(e,i,a){t.temp.npFormula?a():a(new Error("请填写计价单位转计量单位公式！"))}}],punitName:[{required:!0,trigger:"change",validator:function(e,i,a){t.unitData.defaultSelected.length<=0?a(new Error("请选择计价单位")):a()}}]},unitData:{data:{selectUrl:"/system/dictionary/getDictionarys",selectParm:{dictionaryKey:"productUnit",isglobal:"0"}},defaultSelected:[]},formTemp:[],showDialog:!1,visibleState:!1,dialogName:"",formulaState:"",Poption:"",Noption:"",Pprecision:0,Nprecision:0}},created:function(){this.initData.temp&&(this.temp=this.initData.temp,this.temp.remark=""),this.initData.tempLable&&(this.tempLable=this.initData.tempLable)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=n(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},n2pIsScale:function(){return 1===this.Poption},p2nIsScale:function(){return 1===this.Noption},n2pDecimalCount:function(){return this.Pprecision},p2nDecimalCount:function(){return this.Nprecision}},methods:{closeDialog:function(t){this.visibleState=!1,this.showDialog=!1,t&&("n"===this.formulaState?this.temp.npFormula=t:this.temp.pnFormula=t)},openFormulaEdit:function(t){this.dialogName="formulaDialog",this.showDialog=!0,this.formulaState=t,this.visibleState=!0},dialogOpen:function(){this.unitData.defaultSelected=[this.initData.temp.unit],this.temp.punit=this.initData.temp.unit},unitSelect:function(t){t[0]?(this.temp.punit=t[0],this.unitData.defaultSelected=[t[0]]):(this.temp.punit=[],this.unitData.defaultSelected=[])},dialogClose:function(t){this.$emit("close-dialog",t||{})},save:function(){var t=this,e=this;e.$refs.submitForm.validate(function(i){if(i){e.dialogLoading=!0;var n=e.temp.npFormula,o=e.temp.pnFormula,l="N",s=t.n2pIsScale;null!=s&&s&&(l="Y");var r="N",c=t.p2nIsScale;null!=c&&c&&(r="Y");var p={productId:e.temp.id,unit:e.temp.punit,remark:e.temp.remark,npFormula:o,n2pIsScale:l,n2pDecimalCount:t.n2pDecimalCount,pnFormula:n,p2nIsScale:r,p2nDecimalCount:t.p2nDecimalCount};Object(a.saveProductUnit)(p).then(function(t){e.dialogLoading=!1,0===t.code&&(e.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),e.isVisible=!1,e.dialogClose({resState:"ok"}))}).catch(function(t){e.dialogLoading=!1})}})}}},l=(i("XAWQ"),i("KHd+")),s=Object(l.a)(o,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"编辑",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"620px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{width:"570px","padding-top":"10px"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[i("el-row",[i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:"货品编码:",prop:"code"}},[i("el-input",{attrs:{disabled:!0},model:{value:t.temp.code,callback:function(e){t.$set(t.temp,"code",e)},expression:"temp.code"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:"货品名称:",prop:"name"}},[i("el-input",{attrs:{disabled:!0},model:{value:t.temp.name,callback:function(e){t.$set(t.temp,"name",e)},expression:"temp.name"}})],1)],1)],1),t._v(" "),i("el-row",[i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:"计量单位:"}},[i("el-input",{attrs:{disabled:!0},model:{value:t.temp.unitName,callback:function(e){t.$set(t.temp,"unitName",e)},expression:"temp.unitName"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:"计价单位:",prop:"punitName"}},[i("base-input-select",{attrs:{data:t.unitData.data},on:{callback:t.unitSelect},model:{value:t.unitData.defaultSelected,callback:function(e){t.$set(t.unitData,"defaultSelected",e)},expression:"unitData.defaultSelected"}})],1)],1)],1),t._v(" "),i("el-row",[i("el-col",{attrs:{span:16}},[i("el-form-item",{attrs:{label:"计量单位转换计价单位(公式):",prop:"pnFormula"}},[i("el-input",{attrs:{type:"textarea",rows:"3",disabled:!0},model:{value:t.temp.pnFormula,callback:function(e){t.$set(t.temp,"pnFormula",e)},expression:"temp.pnFormula"}}),t._v(" "),i("el-button",{attrs:{type:"text",icon:"el-icon-plus"},on:{click:function(e){t.openFormulaEdit("p")}}},[t._v("公式编辑器")])],1)],1),t._v(" "),i("el-col",{staticStyle:{"padding-top":"3px"},attrs:{span:8}},[i("el-radio-group",{staticClass:"resetFormulaRadioStyle",staticStyle:{width:"100%"},model:{value:t.Poption,callback:function(e){t.Poption=e},expression:"Poption"}},[i("el-radio",{staticStyle:{display:"block",width:"100%","margin-left":"0","padding-left":"5px"},attrs:{label:1}},[t._v("需要四舍五入")]),t._v(" "),i("el-radio",{staticStyle:{display:"block",width:"100%","margin-left":"0",height:"28px","line-height":"30px","padding-left":"5px"},attrs:{label:2}},[t._v("无需四舍五入")])],1),t._v(" "),i("div",{staticClass:"resetFormulaRadioInputStyle",staticStyle:{display:"block",width:"100%","margin-left":"0","padding-left":"5px"}},[t._v("\n            保留小数"),i("el-input-number",{attrs:{size:"mini",max:4,min:0},model:{value:t.Pprecision,callback:function(e){t.Pprecision=e},expression:"Pprecision"}}),t._v("位\n          ")],1)],1)],1),t._v(" "),i("el-row",[i("el-col",{attrs:{span:16}},[i("el-form-item",{attrs:{label:"计价单位转换计量单位(公式):",prop:"npFormula"}},[i("el-input",{attrs:{type:"textarea",rows:"3",disabled:!0},model:{value:t.temp.npFormula,callback:function(e){t.$set(t.temp,"npFormula",e)},expression:"temp.npFormula"}}),t._v(" "),i("el-button",{attrs:{type:"text",icon:"el-icon-plus"},on:{click:function(e){t.openFormulaEdit("n")}}},[t._v("公式编辑器")])],1)],1),t._v(" "),i("el-col",{staticStyle:{"padding-top":"3px"},attrs:{span:8}},[i("el-radio-group",{staticClass:"resetFormulaRadioStyle",staticStyle:{width:"100%"},model:{value:t.Noption,callback:function(e){t.Noption=e},expression:"Noption"}},[i("el-radio",{staticStyle:{display:"block",width:"100%","margin-left":"0","padding-left":"5px"},attrs:{label:1}},[t._v("需要四舍五入")]),t._v(" "),i("el-radio",{staticStyle:{display:"block",width:"100%","margin-left":"0",height:"28px","line-height":"30px","padding-left":"5px"},attrs:{label:2}},[t._v("无需四舍五入")])],1),t._v(" "),i("div",{staticClass:"resetFormulaRadioInputStyle",staticStyle:{display:"block",width:"100%","margin-left":"0","padding-left":"5px"}},[t._v("\n            保留小数"),i("el-input-number",{attrs:{size:"mini",max:4,min:0},model:{value:t.Nprecision,callback:function(e){t.Nprecision=e},expression:"Nprecision"}}),t._v("位\n          ")],1)],1)],1),t._v(" "),i("el-row",[i("el-col",{attrs:{span:24}},[i("el-form-item",{attrs:{label:"备注:",prop:"remark"}},[i("el-input",{staticStyle:{width:"450px"},attrs:{type:"textarea",rows:"2"},model:{value:t.temp.remark,callback:function(e){t.$set(t.temp,"remark",e)},expression:"temp.remark"}})],1)],1)],1)],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1),t._v(" "),t.showDialog?i(t.dialogName,{tag:"component",attrs:{state:t.formulaState,visible:t.visibleState},on:{"close-dialog":t.closeDialog}}):t._e()],1)},[],!1,null,null,null);s.options.__file="dialogUnitAdd.vue";e.default=s.exports},eIWk:function(t,e,i){"use strict";i("rGqo"),i("dRSK"),i("SRfc"),i("xfY5"),i("7h0T"),i("KKXr"),i("pIFo");var a={name:"keyboard",components:{},props:{config:{type:Array,default:function(){return[]}},lockVar:{type:Boolean,default:!1}},data:function(){return{}},computed:{setConfig:function(){return this.config},setLockVar:function(){return this.lockVar}},watch:{},methods:{closeKeyboard:function(){this.$emit("update:popovervisible",!1)}},created:function(){},mounted:function(){}},n=(i("nXfM"),i("KHd+")),o=Object(n.a)(a,function(){var t=this.$createElement,e=this._self._c||t;return e("el-col",{staticClass:"keyboard",staticStyle:{width:"180px",height:"270px"}},[e("div",{staticClass:"buttonView clearfix"},[this._l(this.setConfig,function(t,i){return[e("div",{staticClass:"buttonBox"},[e("el-button",{staticClass:"resetIcon",attrs:{disabled:"undefined"!==t.disabled&&t.disabled,type:t.type?t.type:"primary"},on:{click:function(e){t.method(t.targetKey,t.key)}}},[e("svg-icon",{attrs:{"icon-class":t.icon}})],1)],1)]})],2),this._v(" "),e("div",{staticClass:"btns",staticStyle:{"text-align":"center",height:"50px","padding-top":"12px"}},[e("el-button",{attrs:{size:"mini"},on:{click:this.closeKeyboard}},[this._v("关闭")])],1)])},[],!1,null,null,null);o.options.__file="keyboard.vue";var l=o.exports,s=i("z0WU"),r={name:"formula-edit",props:{options:{type:Array,default:function(){return[{id:"metering",label:"N",remark:"计量单位"},{id:"valuation",label:"P",remark:"计价单位"}]}},state:[String]},data:function(){return{formData:{result:""},result:"",value:"",metering:"N",valuation:"P",userShortcuts:!1,resultRules:[{validator:function(t,e,i){if(!e)return i(new Error("请输入公式"));var a=function(t,e){if(t=t.replace(/\s/g,""),/^[\+\-\*\/]/.test(t))return"错误情况，运算符开头";if(/[\+\-\*\/]$/.test(t))return"错误情况，运算符结尾";if(""===t)return"错误情况，输入为空";if(/[\+\-\*\/]{2,}/.test(t))return"错误情况，运算符连续";if(/\(\)/.test(t))return"错误情况，空括号";if(/\.\D+/.test(t))return"错误情况，小数点后面不是数字";for(var i=[],a=0;a<t.length;a++)if("("===(n=t.charAt(a)))i.push("(");else if(")"===n){if(!(i.length>0))return!1;i.pop()}if(0!==i.length)return"错误情况，括号不配对";if(/\([\+\-\*\/]/.test(t))return"错误情况，(后面是运算符 ";if(/[\+\-\*\/]\)/.test(t))return"错误情况，)前面是运算符";if(e)for(var n,o=t.replace(/[\(\)\+\-\*\/]{1,}/g,"`"),l=o.split("`"),a=0;a<l.length;a++)if(n=l[a],/[A-Z]/i.test(n)&&void 0===e[n])return"错误情况，变量没有来自“待选公式变量”";return 1}(e),n=function(t){var e,i=t.replace(/N|P/g,1);try{e=Number.isNaN(Object(s.k)(i))}catch(t){e=!0}return e}(e);1!==a||n?i(new Error(a)):i()},trigger:"change"}],popovervisible:!1,leftStr:"",rightStr:"",lockVar:!1,keyboardConfig:[{type:"primary",method:this.inputKey,key:"(",targetKey:"rightStr",icon:"leftbracket"},{type:"primary",method:this.inputKey,key:")",targetKey:"rightStr",icon:"rightbracket"},{type:"danger",method:this.deleteKey,key:"",targetKey:"rightStr",icon:"backspace"},{type:"primary",method:this.inputKey,key:"+",targetKey:"rightStr",icon:"formulaAdd"},{type:"primary",method:this.inputKey,key:7,targetKey:"rightStr",icon:"number7"},{type:"primary",method:this.inputKey,key:8,targetKey:"rightStr",icon:"number8"},{type:"primary",method:this.inputKey,key:9,targetKey:"rightStr",icon:"number9"},{type:"primary",method:this.inputKey,key:"/",targetKey:"rightStr",icon:"formulaDivide"},{type:"primary",method:this.inputKey,key:4,targetKey:"rightStr",icon:"number4"},{type:"primary",method:this.inputKey,key:5,targetKey:"rightStr",icon:"number5"},{type:"primary",method:this.inputKey,key:6,targetKey:"rightStr",icon:"number6"},{type:"primary",method:this.inputKey,key:"*",targetKey:"rightStr",icon:"formulaMultiply"},{type:"primary",method:this.inputKey,key:1,targetKey:"rightStr",icon:"number1"},{type:"primary",method:this.inputKey,key:2,targetKey:"rightStr",icon:"number2"},{type:"primary",method:this.inputKey,key:3,targetKey:"rightStr",icon:"number3"},{type:"primary",method:this.inputKey,key:"-",targetKey:"rightStr",icon:"formulaSubtract"},{type:"primary",method:this.inputKey,key:"",targetKey:"rightStr",disabled:!0,icon:"AC"},{type:"primary",method:this.inputKey,key:0,targetKey:"rightStr",icon:"number0"},{type:"primary",method:this.inputKey,key:".",targetKey:"rightStr",icon:"spot"},{type:"warning",method:this.inputKey,key:"N",disabled:!1,targetKey:"rightStr",icon:"N"}],isParams:!1,messageStr:"N为计量单位，P为计价单位"}},components:{"key-board":l},computed:{setKey:function(){return this.value?this[this.value]:"N"},formatOptions:function(){return this.options.map(function(t){return t.isdisable=!1,t})},refreshState:function(){return!(!this.isParams&&(this.result||this.value||this.leftStr||this.rightStr))},formulaResult:function(){return this.rightStr},formulaTitle:function(){return this.result?this[this.result]+" =":""}},watch:{formulaResult:function(t){this.formData.result=t},value:function(t){var e=this.value?this[this.value]:"N";this.keyboardConfig[this.keyboardConfig.length-1].key=e,this.keyboardConfig[this.keyboardConfig.length-1].icon=e},rightStr:function(){this.rightStr.match(/[N|P]/)?(this.lockVar=!0,this.keyboardConfig[this.keyboardConfig.length-1].disabled=!0):(this.lockVar=!1,this.keyboardConfig[this.keyboardConfig.length-1].disabled=!1)}},methods:{sendFormula:function(){var t=this;this.$refs.formulaForm.validate(function(e){e&&t.result&&t.value&&t.$emit("send-formula",t.formulaTitle.replace(/\s/g,"")+t.formData.result)})},clearReslut:function(){this.rightStr=""},closeFormula:function(){this.$emit("send-formula","")},changeState:function(){"metering"===this.result?this.keyboardConfig.state="2":this.keyboardConfig.state="1"},closePopover:function(t){this["popoverVisible"+t]=!1},deleteKey:function(t){this[t].length&&(this[t]=this[t].substr(0,this[t].length-1))},inputKey:function(t,e){this[t]+=e},endInput:function(t){this["popoverVisible"+t]=!1},setSelect:function(t){this.userShortcuts=!0,this.result=t,"valuation"===t&&(this.value="metering"),"metering"===t&&(this.value="valuation")},selected:function(t){return this.value?this.result?void 0:(this.result="valuation"===t?"metering":"valuation",void(this.userShortcuts=!0)):(this.value="valuation"===t?"metering":"valuation",void(this.userShortcuts=!0))},inverseFn:function(t){if(!t)return"";var e=t.match(/N+/g),i=t.match(/P+/g);if(e&&i)return"";if(e){var a=t.match(/\((.+?)\)/g);a&&a&&a.find(function(e,i){if(e.indexOf("N")>-1){var a=t.split(e),n=a.map(function(t){return""});a.forEach(function(t,e){if(t){var i=t.charAt(0),a=t.charAt(t.length-1),o={};if(i&&/[\+\-\*\/]/.test(i)){switch(i){case"+":o.symbol="-";break;case"-":o.symbol="+";break;case"*":o.symbol="/";break;case"/":o.symbol="*"}o.position="left",o.str=t.substring(1)}else if(a&&/[\+\-\*\/]/.test(a)){switch(a){case"+":o.symbol="-";break;case"-":o.symbol="+";break;case"*":o.symbol="/";break;case"/":o.symbol="*"}o.position="right",o.str=t.substring(0,t.length-1)}n.splice(e,1,o)}}),n.forEach(function(t,e){t&&("left"===t.position?t.str=t.symbol+t.str:"right"===t.position&&("*"===t.symbol?t.str=t.str+"/":"+"===t.symbol?t.str=t.str+"-":t.str=t.symbol+t.str))})}})}}},created:function(){this.state&&(this.isParams=!0,this.userShortcuts=!0,"n"===this.state&&(this.result="metering")&&(this.value="valuation"),"p"===this.state&&(this.result="valuation")&&(this.value="metering"))},mounted:function(){},beforeDestroy:function(){}},c=(i("Y29c"),Object(n.a)(r,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"formulaEdit"},[i("el-form",{ref:"formulaForm",attrs:{"label-position":"right",model:t.formData,"label-width":"85px"}},[i("el-form-item",{attrs:{label:"变量说明："}},[i("el-input",{staticStyle:{"text-align":"left"},attrs:{disabled:!0},domProps:{textContent:t._s(t.messageStr)}})],1),t._v(" "),i("el-form-item",{attrs:{label:"公式预览：",prop:"result",rules:t.resultRules}},[i("el-input",{staticClass:"resetSpan",attrs:{disabled:!0},model:{value:t.formData.result,callback:function(e){t.$set(t.formData,"result",e)},expression:"formData.result"}},[i("span",{staticStyle:{width:"100%"},attrs:{slot:"prefix"},slot:"prefix"},[i("span",{domProps:{textContent:t._s(t.formulaTitle)}})])])],1),t._v(" "),i("el-form-item",{attrs:{label:"公式输入："}},[i("el-row",{staticStyle:{"text-align":"center"}},[i("el-col",{attrs:{span:5}},[i("el-select",{attrs:{disabled:!!t.result&&t.userShortcuts,"popper-class":"popperClass",placeholder:"设置变量"},on:{change:t.selected},model:{value:t.result,callback:function(e){t.result=e},expression:"result"}},t._l(t.formatOptions,function(e){return i("el-option",{key:e.id,attrs:{label:e.label,value:e.id}},[i("span",{staticStyle:{float:"left"}},[t._v(t._s(e.label))]),t._v(" "),e.remark?i("span",{staticStyle:{float:"right",color:"#8492a6","font-size":"13px"}},[t._v(t._s(e.remark))]):t._e()])}),1)],1),t._v(" "),i("el-col",{staticStyle:{color:"#000","padding-top":"5px"},attrs:{span:2}},[i("el-button",{staticClass:"resetIcon onesIcon",attrs:{disabled:!0}},[i("svg-icon",{attrs:{"icon-class":"equal"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:15}},[i("el-popover",{attrs:{title:"公式键盘"},model:{value:t.popovervisible,callback:function(e){t.popovervisible=e},expression:"popovervisible"}},[i("key-board",{attrs:{config:t.keyboardConfig,lockVar:t.lockVar,popovervisible:t.popovervisible},on:{"update:popovervisible":function(e){t.popovervisible=e}}}),t._v(" "),i("el-input",{ref:"popoverInput1",attrs:{slot:"reference",readonly:!0,placeholder:"点击输入常量"},on:{focus:t.changeState},slot:"reference",model:{value:t.rightStr,callback:function(e){t.rightStr=e},expression:"rightStr"}})],1)],1),t._v(" "),i("el-col",{staticStyle:{color:"#000","padding-top":"5px"},attrs:{span:2}},[i("el-button",{staticClass:"resetIcon onesIcon",attrs:{title:"重置公式",type:"primary",disabled:t.refreshState},on:{click:t.clearReslut}},[i("svg-icon",{attrs:{"icon-class":"refresh"}})],1)],1)],1)],1)],1),t._v(" "),i("el-row",{staticClass:"btns"},[i("el-button",{attrs:{type:"primary"},on:{click:t.sendFormula}},[t._v("保 存")]),t._v(" "),i("el-button",{on:{click:t.closeFormula}},[t._v("关 闭")])],1)],1)},[],!1,null,null,null));c.options.__file="index.vue";e.a=c.exports},fsTK:function(t,e,i){"use strict";i.r(e);i("yt8O"),i("RW0V"),i("rGqo");var a=i("mSNy"),n=i("a0Xs"),o=i("dpNl"),l=i("L4vu"),s=i("z0WU");function r(t){for(var e=1;e<arguments.length;e++){var i=null!=arguments[e]?arguments[e]:{},a=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(a=a.concat(Object.getOwnPropertySymbols(i).filter(function(t){return Object.getOwnPropertyDescriptor(i,t).enumerable}))),a.forEach(function(e){c(t,e,i[e])})}return t}function c(t,e,i){return e in t?Object.defineProperty(t,e,{value:i,enumerable:!0,configurable:!0,writable:!0}):t[e]=i,t}var p={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n\t\t\t\t\t\t<div slot-scope="scope">\n    \t\t\t\t\t\t<el-switch active-value="1" inactive-value="0" v-model="scope.row.isdisable" :disabled="scope.row.type===\'计量单位\'" @change="colConfig.changeState(scope.row,scope.$index)"></el-switch>\n    \t\t\t\t\t</div>\n    \t\t\t   </el-table-column>'},u={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n\t\t\t\t\t\t<div slot-scope="scope">\n    \t\t\t\t\t\t<el-switch active-value="1" inactive-value="0"  v-model="scope.row.isdefault" :disabled="scope.row.isdefault===\'1\'" @change="colConfig.changeIsdefault(scope.row,scope.$index)"></el-switch>\n    \t\t\t\t\t</div>\n    \t\t\t   </el-table-column>'},d={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n      \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n      \t\t\t\t\t\t\t<el-button  v-show="colConfig.editBtns_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.editBtns(scope.row,scope.$index)">编辑</el-button>\n      \t\t\t\t\t\t\t<el-button  v-show="colConfig.deleteBtns_isShow&&scope.row.isdisable==\'0\'" type="text" class="btns" style="font-size: 12px;" @click="colConfig.deleteBtns(scope.row,scope.$index)">删除</el-button>\n      \t\t\t\t\t</div>\n\n    \t\t\t\t</el-table-column>'},m={name:"dialog-option",props:["initData","visible"],data:function(){return{dialogTopLoading:!1,isVisible:!1,title:"",userInfo:null,topBarBtnList:[{name:"查询",icon:"search",method:this.queryTable},{name:"重置",icon:"refresh",plain:!0,method:this.resetQueryTemp}],initConfigs:{tableOperates:{prop:"operate",label:"操作",enLabel:"operation",btnName:"编辑",isPropName:!0,component:d,editBtns:this.editBtns,editBtns_isShow:!0,deleteBtns:this.deleteBtns,deleteBtns_isShow:!0}},configs:{topBarBtnList:[{name:"新增",nameEn:"add",isShow:!0,icon:"add",method:this.addNew}],tableConfigs:[],showCheckBox:!1,showIndex:!1,isSingle:!1},tableData:[],selectList:[],queryParms:[{name:"code"},{name:"name"}],temp:{},tempQuery:{},tempLable:{},pageData:null,pageNo:1,openDialogName:"",showDialog:!1,visibleState:!1,dialogData:{title:"",temp:null,tempLable:null}}},components:{dialogUnitAdd:o.default,dialogUnitEdit:l.default},beforeCreate:function(){},created:function(){this.title=this.initData.title,this.configs.isSingle=this.initData.isSingle,this.userInfo=this.$storage.get("userInfo"),this.initTable(!0)},beforeMount:function(){},mounted:function(){this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{editBtns:function(t,e){var i=JSON.parse(JSON.stringify(t)),a=i.npFormula,n=i.pnFormula;i.pnFormula=a,i.npFormula=n,this.dialogData.temp=i,this.dialogData.temp.unitName=this.initData.temp.unitName,this.dialogData.tempLable=this.tempLable,this.dialogData.title="编辑",this.openDialogName="dialogUnitEdit",this.showDialog=!0,this.visibleState=!0},changeState:function(t,e){Object(n.updateDisableProductUnit)(t.id,t.isdisable).then(function(t){}).catch(function(t){console.log(t)})},deleteBtns:function(t,e){var i=this;i.$confirm("此操作将永久删除该记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(n.deleteProductUnit)(t.id).then(function(t){0===t.code&&(i.$notify({title:"成功",message:"删除成功",type:"success",duration:2e3}),i.initTable(!0))}).catch(function(t){console.log(t)})}).catch(function(){i.$message({type:"info",message:"已取消删除"})})},dialogClose:function(){this.$emit("close-dialog",{resState:"ok"})},queryTable:function(){this.pageNo=1,this.initTable(!0)},initTable:function(t){var e=this;e.dialogTopLoading=!0,Object(n.listPageProductUnits)(r({},e.tempQuery,{productId:this.initData.temp.id,pageNo:e.pageNo})).then(function(i){e.getListPage(i),t&&(e.dialogTopLoading=!1)}).catch(function(t){e.dialogTopLoading=!1})},getListPage:function(t){if(t){this.pageData=t.result.pageData,this.initTempData(t.result.titles);var e=Object(s.n)(t.result),i=this.addTableTitle(e);this.configs.tableConfigs=i,this.configs.showCheckBox=!0,this.configs.showIndex=!0,this.tableData=t.result.varList}},initTempData:function(t){var e=this;t.forEach(function(t){for(var i in t){var n=t[i];n.indexOf("_")>0&&("en"==a.a.locale?n=n.substring(n.indexOf("_")+1):"zh"==a.a.locale&&(n=n.substring(0,n.indexOf("_")))),e.tempLable[i]=n}})},addTableTitle:function(t){var e=this;return t.forEach(function(t){var i=t.label;i.indexOf("_")>0&&("en"==a.a.locale?t.label=i.substring(i.indexOf("_")+1):"zh"==a.a.locale&&(t.label=i.substring(0,i.indexOf("_")))),"是否启用"===t.label&&(t.component=p,t.changeState=e.changeState),"是否默认"===t.label&&(t.component=u,t.changeIsdefault=e.changeIsdefault)}),t.push(e.initConfigs.tableOperates),t},addNew:function(){this.dialogData.temp=this.initData.temp,this.dialogData.tempLable=this.initData.tempLable,this.dialogData.title="新增计价单位",this.openDialogName="dialogUnitAdd",this.showDialog=!0,this.visibleState=!0},resetTemp:function(){for(var t in this.temp)this.temp[t]=""},changeIsdefault:function(t,e){var i=this;Object(n.updateIsDefaultProductUnit)(t.id,t.isdefault,t.productId).then(function(t){i.refreshTable()}).catch(function(t){console.log(t)})},closeDialog:function(t){this.showDialog=!1,"ok"===t.resState&&this.refreshTable()},refreshTable:function(){var t=this;t.$axios.all([Object(n.listPageProductUnits)(r({},t.tempQuery,{productId:this.initData.temp.id,pageNo:t.pageNo}))]).then(t.$axios.spread(function(e){t.getListPage(e)})).catch(function(t){console.log(t)})},dataBridge:function(t){this.selectList=t},resetQueryTemp:function(){for(var t in this.tempQuery)this.tempQuery[t]=""}},computed:{dialogName:function(){return this.openDialogName}},watch:{pageNo:function(){this.initTable()}}},h=i("KHd+"),f=Object(h.a)(m,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.title,visible:t.isVisible,"append-to-body":"",width:"1000px"},on:{"update:visible":function(e){t.isVisible=e},close:t.dialogClose}},[t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visibleState},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogTopLoading,expression:"dialogTopLoading"}]},[t.configs.topBarBtnList&&t.configs.topBarBtnList.length?i("div",{staticStyle:{height:"50px","box-sizing":"border-box",padding:"7px 20px 7px 7px"}},[t._l(t.configs.topBarBtnList,function(t,e){return[i("base-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"item.isShow"}],attrs:{name:t.name,icon:t.icon,plain:t.plain,state:t.state},on:{myclick:t.method}})]})],2):t._e(),t._v(" "),i("div",{staticStyle:{padding:"7px"}},[i("base-table",{attrs:{data:t.tableData,colConfigs:t.configs.tableConfigs,showCheckBox:t.configs.showCheckBox,showIndex:t.configs.showIndex,isSingle:t.configs.isSingle,isSortable:!1,pageData:t.pageData,currentpage:t.pageNo},on:{databridge:t.dataBridge,"update:currentpage":function(e){t.pageNo=e}}})],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)])],1)},[],!1,null,null,null);f.options.__file="dialogUnit.vue";e.default=f.exports},nXfM:function(t,e,i){"use strict";var a=i("bUBY");i.n(a).a}}]);