(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-8dd6"],{"9Edw":function(t,e,i){},Ck00:function(t,e,i){"use strict";var r={name:"formula-dialog",props:["visible","state"],components:{formulaEdit:i("eIWk").a},data:function(){return{innerVisible:!1,formulaStr:""}},computed:{setState:function(){return this.state}},watch:{},methods:{formula:function(t){this.formulaStr=t,this.innerVisible=!1},dialogClose:function(){this.$emit("close-dialog",this.formulaStr)}},created:function(){},mounted:function(){this.innerVisible=this.visible}},a=i("KHd+"),o=Object(a.a)(r,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{width:"650px",title:"公式编辑器",visible:t.innerVisible,"append-to-body":""},on:{"update:visible":function(e){t.innerVisible=e},close:t.dialogClose}},[i("div",{staticStyle:{padding:"10px","text-align":"center"}},[i("formula-edit",{attrs:{state:t.setState},on:{"send-formula":t.formula}})],1)])},[],!1,null,null,null);o.options.__file="dialog.vue";e.a=o.exports},Y29c:function(t,e,i){"use strict";var r=i("9Edw");i.n(r).a},bUBY:function(t,e,i){},eIWk:function(t,e,i){"use strict";i("rGqo"),i("dRSK"),i("SRfc"),i("xfY5"),i("7h0T"),i("KKXr"),i("pIFo");var r={name:"keyboard",components:{},props:{config:{type:Array,default:function(){return[]}},lockVar:{type:Boolean,default:!1}},data:function(){return{}},computed:{setConfig:function(){return this.config},setLockVar:function(){return this.lockVar}},watch:{},methods:{closeKeyboard:function(){this.$emit("update:popovervisible",!1)}},created:function(){},mounted:function(){}},a=(i("nXfM"),i("KHd+")),o=Object(a.a)(r,function(){var t=this.$createElement,e=this._self._c||t;return e("el-col",{staticClass:"keyboard",staticStyle:{width:"180px",height:"270px"}},[e("div",{staticClass:"buttonView clearfix"},[this._l(this.setConfig,function(t,i){return[e("div",{staticClass:"buttonBox"},[e("el-button",{staticClass:"resetIcon",attrs:{disabled:"undefined"!==t.disabled&&t.disabled,type:t.type?t.type:"primary"},on:{click:function(e){t.method(t.targetKey,t.key)}}},[e("svg-icon",{attrs:{"icon-class":t.icon}})],1)],1)]})],2),this._v(" "),e("div",{staticClass:"btns",staticStyle:{"text-align":"center",height:"50px","padding-top":"12px"}},[e("el-button",{attrs:{size:"mini"},on:{click:this.closeKeyboard}},[this._v("关闭")])],1)])},[],!1,null,null,null);o.options.__file="keyboard.vue";var n=o.exports,s=i("z0WU"),l={name:"formula-edit",props:{options:{type:Array,default:function(){return[{id:"metering",label:"N",remark:"计量单位"},{id:"valuation",label:"P",remark:"计价单位"}]}},state:[String]},data:function(){return{formData:{result:""},result:"",value:"",metering:"N",valuation:"P",userShortcuts:!1,resultRules:[{validator:function(t,e,i){if(!e)return i(new Error("请输入公式"));var r=function(t,e){if(t=t.replace(/\s/g,""),/^[\+\-\*\/]/.test(t))return"错误情况，运算符开头";if(/[\+\-\*\/]$/.test(t))return"错误情况，运算符结尾";if(""===t)return"错误情况，输入为空";if(/[\+\-\*\/]{2,}/.test(t))return"错误情况，运算符连续";if(/\(\)/.test(t))return"错误情况，空括号";if(/\.\D+/.test(t))return"错误情况，小数点后面不是数字";for(var i=[],r=0;r<t.length;r++)if("("===(a=t.charAt(r)))i.push("(");else if(")"===a){if(!(i.length>0))return!1;i.pop()}if(0!==i.length)return"错误情况，括号不配对";if(/\([\+\-\*\/]/.test(t))return"错误情况，(后面是运算符 ";if(/[\+\-\*\/]\)/.test(t))return"错误情况，)前面是运算符";if(e)for(var a,o=t.replace(/[\(\)\+\-\*\/]{1,}/g,"`"),n=o.split("`"),r=0;r<n.length;r++)if(a=n[r],/[A-Z]/i.test(a)&&void 0===e[a])return"错误情况，变量没有来自“待选公式变量”";return 1}(e),a=function(t){var e,i=t.replace(/N|P/g,1);try{e=Number.isNaN(Object(s.k)(i))}catch(t){e=!0}return e}(e);1!==r||a?i(new Error(r)):i()},trigger:"change"}],popovervisible:!1,leftStr:"",rightStr:"",lockVar:!1,keyboardConfig:[{type:"primary",method:this.inputKey,key:"(",targetKey:"rightStr",icon:"leftbracket"},{type:"primary",method:this.inputKey,key:")",targetKey:"rightStr",icon:"rightbracket"},{type:"danger",method:this.deleteKey,key:"",targetKey:"rightStr",icon:"backspace"},{type:"primary",method:this.inputKey,key:"+",targetKey:"rightStr",icon:"formulaAdd"},{type:"primary",method:this.inputKey,key:7,targetKey:"rightStr",icon:"number7"},{type:"primary",method:this.inputKey,key:8,targetKey:"rightStr",icon:"number8"},{type:"primary",method:this.inputKey,key:9,targetKey:"rightStr",icon:"number9"},{type:"primary",method:this.inputKey,key:"/",targetKey:"rightStr",icon:"formulaDivide"},{type:"primary",method:this.inputKey,key:4,targetKey:"rightStr",icon:"number4"},{type:"primary",method:this.inputKey,key:5,targetKey:"rightStr",icon:"number5"},{type:"primary",method:this.inputKey,key:6,targetKey:"rightStr",icon:"number6"},{type:"primary",method:this.inputKey,key:"*",targetKey:"rightStr",icon:"formulaMultiply"},{type:"primary",method:this.inputKey,key:1,targetKey:"rightStr",icon:"number1"},{type:"primary",method:this.inputKey,key:2,targetKey:"rightStr",icon:"number2"},{type:"primary",method:this.inputKey,key:3,targetKey:"rightStr",icon:"number3"},{type:"primary",method:this.inputKey,key:"-",targetKey:"rightStr",icon:"formulaSubtract"},{type:"primary",method:this.inputKey,key:"",targetKey:"rightStr",disabled:!0,icon:"AC"},{type:"primary",method:this.inputKey,key:0,targetKey:"rightStr",icon:"number0"},{type:"primary",method:this.inputKey,key:".",targetKey:"rightStr",icon:"spot"},{type:"warning",method:this.inputKey,key:"N",disabled:!1,targetKey:"rightStr",icon:"N"}],isParams:!1,messageStr:"N为计量单位，P为计价单位"}},components:{"key-board":n},computed:{setKey:function(){return this.value?this[this.value]:"N"},formatOptions:function(){return this.options.map(function(t){return t.isdisable=!1,t})},refreshState:function(){return!(!this.isParams&&(this.result||this.value||this.leftStr||this.rightStr))},formulaResult:function(){return this.rightStr},formulaTitle:function(){return this.result?this[this.result]+" =":""}},watch:{formulaResult:function(t){this.formData.result=t},value:function(t){var e=this.value?this[this.value]:"N";this.keyboardConfig[this.keyboardConfig.length-1].key=e,this.keyboardConfig[this.keyboardConfig.length-1].icon=e},rightStr:function(){this.rightStr.match(/[N|P]/)?(this.lockVar=!0,this.keyboardConfig[this.keyboardConfig.length-1].disabled=!0):(this.lockVar=!1,this.keyboardConfig[this.keyboardConfig.length-1].disabled=!1)}},methods:{sendFormula:function(){var t=this;this.$refs.formulaForm.validate(function(e){e&&t.result&&t.value&&t.$emit("send-formula",t.formulaTitle.replace(/\s/g,"")+t.formData.result)})},clearReslut:function(){this.rightStr=""},closeFormula:function(){this.$emit("send-formula","")},changeState:function(){"metering"===this.result?this.keyboardConfig.state="2":this.keyboardConfig.state="1"},closePopover:function(t){this["popoverVisible"+t]=!1},deleteKey:function(t){this[t].length&&(this[t]=this[t].substr(0,this[t].length-1))},inputKey:function(t,e){this[t]+=e},endInput:function(t){this["popoverVisible"+t]=!1},setSelect:function(t){this.userShortcuts=!0,this.result=t,"valuation"===t&&(this.value="metering"),"metering"===t&&(this.value="valuation")},selected:function(t){return this.value?this.result?void 0:(this.result="valuation"===t?"metering":"valuation",void(this.userShortcuts=!0)):(this.value="valuation"===t?"metering":"valuation",void(this.userShortcuts=!0))},inverseFn:function(t){if(!t)return"";var e=t.match(/N+/g),i=t.match(/P+/g);if(e&&i)return"";if(e){var r=t.match(/\((.+?)\)/g);r&&r&&r.find(function(e,i){if(e.indexOf("N")>-1){var r=t.split(e),a=r.map(function(t){return""});r.forEach(function(t,e){if(t){var i=t.charAt(0),r=t.charAt(t.length-1),o={};if(i&&/[\+\-\*\/]/.test(i)){switch(i){case"+":o.symbol="-";break;case"-":o.symbol="+";break;case"*":o.symbol="/";break;case"/":o.symbol="*"}o.position="left",o.str=t.substring(1)}else if(r&&/[\+\-\*\/]/.test(r)){switch(r){case"+":o.symbol="-";break;case"-":o.symbol="+";break;case"*":o.symbol="/";break;case"/":o.symbol="*"}o.position="right",o.str=t.substring(0,t.length-1)}a.splice(e,1,o)}}),a.forEach(function(t,e){t&&("left"===t.position?t.str=t.symbol+t.str:"right"===t.position&&("*"===t.symbol?t.str=t.str+"/":"+"===t.symbol?t.str=t.str+"-":t.str=t.symbol+t.str))})}})}}},created:function(){this.state&&(this.isParams=!0,this.userShortcuts=!0,"n"===this.state&&(this.result="metering")&&(this.value="valuation"),"p"===this.state&&(this.result="valuation")&&(this.value="metering"))},mounted:function(){},beforeDestroy:function(){}},u=(i("Y29c"),Object(a.a)(l,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"formulaEdit"},[i("el-form",{ref:"formulaForm",attrs:{"label-position":"right",model:t.formData,"label-width":"85px"}},[i("el-form-item",{attrs:{label:"变量说明："}},[i("el-input",{staticStyle:{"text-align":"left"},attrs:{disabled:!0},domProps:{textContent:t._s(t.messageStr)}})],1),t._v(" "),i("el-form-item",{attrs:{label:"公式预览：",prop:"result",rules:t.resultRules}},[i("el-input",{staticClass:"resetSpan",attrs:{disabled:!0},model:{value:t.formData.result,callback:function(e){t.$set(t.formData,"result",e)},expression:"formData.result"}},[i("span",{staticStyle:{width:"100%"},attrs:{slot:"prefix"},slot:"prefix"},[i("span",{domProps:{textContent:t._s(t.formulaTitle)}})])])],1),t._v(" "),i("el-form-item",{attrs:{label:"公式输入："}},[i("el-row",{staticStyle:{"text-align":"center"}},[i("el-col",{attrs:{span:5}},[i("el-select",{attrs:{disabled:!!t.result&&t.userShortcuts,"popper-class":"popperClass",placeholder:"设置变量"},on:{change:t.selected},model:{value:t.result,callback:function(e){t.result=e},expression:"result"}},t._l(t.formatOptions,function(e){return i("el-option",{key:e.id,attrs:{label:e.label,value:e.id}},[i("span",{staticStyle:{float:"left"}},[t._v(t._s(e.label))]),t._v(" "),e.remark?i("span",{staticStyle:{float:"right",color:"#8492a6","font-size":"13px"}},[t._v(t._s(e.remark))]):t._e()])}),1)],1),t._v(" "),i("el-col",{staticStyle:{color:"#000","padding-top":"5px"},attrs:{span:2}},[i("el-button",{staticClass:"resetIcon onesIcon",attrs:{disabled:!0}},[i("svg-icon",{attrs:{"icon-class":"equal"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:15}},[i("el-popover",{attrs:{title:"公式键盘"},model:{value:t.popovervisible,callback:function(e){t.popovervisible=e},expression:"popovervisible"}},[i("key-board",{attrs:{config:t.keyboardConfig,lockVar:t.lockVar,popovervisible:t.popovervisible},on:{"update:popovervisible":function(e){t.popovervisible=e}}}),t._v(" "),i("el-input",{ref:"popoverInput1",attrs:{slot:"reference",readonly:!0,placeholder:"点击输入常量"},on:{focus:t.changeState},slot:"reference",model:{value:t.rightStr,callback:function(e){t.rightStr=e},expression:"rightStr"}})],1)],1),t._v(" "),i("el-col",{staticStyle:{color:"#000","padding-top":"5px"},attrs:{span:2}},[i("el-button",{staticClass:"resetIcon onesIcon",attrs:{title:"重置公式",type:"primary",disabled:t.refreshState},on:{click:t.clearReslut}},[i("svg-icon",{attrs:{"icon-class":"refresh"}})],1)],1)],1)],1)],1),t._v(" "),i("el-row",{staticClass:"btns"},[i("el-button",{attrs:{type:"primary"},on:{click:t.sendFormula}},[t._v("保 存")]),t._v(" "),i("el-button",{on:{click:t.closeFormula}},[t._v("关 闭")])],1)],1)},[],!1,null,null,null));u.options.__file="index.vue";e.a=u.exports},iA4u:function(t,e,i){"use strict";i.r(e);i("rE2o"),i("ioFf");var r=i("a0Xs");function a(t){return(a="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var o={components:{formulaDialog:i("Ck00").a},name:"dialog-edit",props:["initData","visible"],data:function(){var t=this;return{dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{},rules:{punitName:[{required:!0,trigger:"change",validator:function(e,i,r){t.unitData.defaultSelected.length<=0?r(new Error("请选择计价单位")):r()}}]},unitData:{data:{selectUrl:"/system/dictionary/getDictionarys",selectParm:{dictionaryKey:"productUnit",isglobal:"0"}},defaultSelected:[]},formTemp:[],showDialog:!1,visibleState:!1,dialogName:"",formulaState:""}},created:function(){this.initData.temp&&(this.temp=this.initData.temp),this.initData.tempLable&&(this.tempLable=this.initData.tempLable)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=a(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]}},methods:{openFormulaEdit:function(t){this.dialogName="formulaDialog",this.showDialog=!0,this.formulaState=t,this.visibleState=!0},dialogOpen:function(){this.unitData.defaultSelected=[this.initData.temp.punit],this.temp.unit=this.initData.temp.punit},unitSelect:function(t){t[0]?(this.temp.unit=t[0],this.unitData.defaultSelected=[t[0]]):(this.temp.unit=[],this.unitData.defaultSelected=[])},dialogClose:function(t){this.$emit("close-dialog",t||{})},save:function(){var t=this;t.$refs.submitForm.validate(function(e){e&&(t.dialogLoading=!0,Object(r.updateProductUnit)(t.temp).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){t.dialogLoading=!1}))})}}},n=i("KHd+"),s=Object(n.a)(o,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"编辑",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"620px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}]},[i("el-form",{ref:"submitForm",staticStyle:{width:"570px",margin:"10px auto"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[i("el-row",[i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:"单位类型:",prop:"type"}},[i("el-input",{attrs:{disabled:!0},model:{value:t.temp.type,callback:function(e){t.$set(t.temp,"type",e)},expression:"temp.type"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:"单位:",prop:"punitName"}},[i("base-input-select",{attrs:{data:t.unitData.data},on:{callback:t.unitSelect},model:{value:t.unitData.defaultSelected,callback:function(e){t.$set(t.unitData,"defaultSelected",e)},expression:"unitData.defaultSelected"}})],1)],1)],1),t._v(" "),i("el-row",[i("el-col",{attrs:{span:24}},[i("el-form-item",{directives:[{name:"show",rawName:"v-show",value:"计价单位"==t.temp.type,expression:"temp.type=='计价单位'"}],attrs:{label:"计量单位转换计价单位(公式):",prop:"npFormula"}},[i("el-input",{staticStyle:{width:"450px"},attrs:{type:"textarea",rows:"3",disabled:!0},model:{value:t.temp.npFormula,callback:function(e){t.$set(t.temp,"npFormula",e)},expression:"temp.npFormula"}}),t._v(" "),i("el-button",{attrs:{type:"text",icon:"el-icon-plus"},on:{click:function(e){t.openFormulaEdit("n")}}},[t._v("公式编辑器")])],1)],1)],1),t._v(" "),i("el-row",[i("el-col",{attrs:{span:24}},[i("el-form-item",{directives:[{name:"show",rawName:"v-show",value:"计价单位"==t.temp.type,expression:"temp.type=='计价单位'"}],attrs:{label:"计价单位转换计量单位(公式):",prop:"pnFormula"}},[i("el-input",{staticStyle:{width:"450px"},attrs:{type:"textarea",rows:"3",disabled:!0},model:{value:t.temp.pnFormula,callback:function(e){t.$set(t.temp,"pnFormula",e)},expression:"temp.pnFormula"}}),t._v(" "),i("el-button",{attrs:{type:"text",icon:"el-icon-plus"},on:{click:function(e){t.openFormulaEdit("p")}}},[t._v("公式编辑器")])],1)],1)],1),t._v(" "),i("el-row",[i("el-col",{attrs:{span:24}},[i("el-form-item",{attrs:{label:"备注:",prop:"remark"}},[i("el-input",{staticStyle:{width:"450px"},attrs:{type:"textarea",rows:"2"},model:{value:t.temp.remark,callback:function(e){t.$set(t.temp,"remark",e)},expression:"temp.remark"}})],1)],1)],1)],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1),t._v(" "),t.showDialog?i(t.dialogName,{tag:"component",attrs:{state:t.formulaState,visible:t.visibleState},on:{"close-dialog":t.closeDialog}}):t._e()],1)},[],!1,null,null,null);s.options.__file="dialogUnitEdit.vue";e.default=s.exports},nXfM:function(t,e,i){"use strict";var r=i("bUBY");i.n(r).a}}]);