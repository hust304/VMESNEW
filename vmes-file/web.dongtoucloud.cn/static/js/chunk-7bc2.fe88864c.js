(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-7bc2","chunk-6492"],{Ri2b:function(t,e,i){"use strict";var a=i("uas5");i.n(a).a},fydv:function(t,e,i){"use strict";i("rE2o"),i("ioFf"),i("f3/d"),i("xfY5");var a=i("z0WU"),o=(i("91GP"),i("jUE0"),i("QWlu")),s="@@wavesContext";function n(t,e){function i(i){var a=Object.assign({},e.value),o=Object.assign({ele:t,type:"hit",color:"rgba(0, 0, 0, 0.15)"},a),s=o.ele;if(s){s.style.position="relative",s.style.overflow="hidden";var n=s.getBoundingClientRect(),l=s.querySelector(".waves-ripple");switch(l?l.className="waves-ripple":((l=document.createElement("span")).className="waves-ripple",l.style.height=l.style.width=Math.max(n.width,n.height)+"px",s.appendChild(l)),o.type){case"center":l.style.top=n.height/2-l.offsetHeight/2+"px",l.style.left=n.width/2-l.offsetWidth/2+"px";break;default:l.style.top=(i.pageY-n.top-l.offsetHeight/2-document.documentElement.scrollTop||document.body.scrollTop)+"px",l.style.left=(i.pageX-n.left-l.offsetWidth/2-document.documentElement.scrollLeft||document.body.scrollLeft)+"px"}return l.style.backgroundColor=o.color,l.className="waves-ripple z-active",!1}}return t[s]?t[s].removeHandle=i:t[s]={removeHandle:i},i}var l={bind:function(t,e){o.a.on(t,"click",n(t,e))},update:function(t,e){o.a.off(t,"click",t[s].removeHandle),o.a.on(t,"click",n(t,e))},unbind:function(t){o.a.off(t,"click",t[s].removeHandle),t[s]=null,delete t[s]}},r=function(t){t.directive("waves",l)};function u(t){return(u="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}window.Vue&&(window.waves=l,Vue.use(r)),l.install=r;var c={name:"equipment-formula",props:{width:[String,Number],customSign:{type:Array,default:function(){return[]}},renameKey:{type:Object,default:function(){return null}},apiObj:{type:Object,default:function(){return null}},paramName:{type:String,default:""}},directives:{waves:l},data:function(){return{testList:[],baseSign:["7","8","9","+","4","5","6","-","1","2","3","*","(","0",".","/",")","退格","清空","="],boldContent:["7","8","9","4","5","6","1","2","3","0","."],boldSign:["+","-","*","/","=","(",")"],resultStr:[],leftBtnsBoxHeight:0,showLeftArrow:!1,leftScrollTop:0,maxLeftScrollTop:0,scrollSwitch:!0,animateTimer:"",arrowState:!0,isClick:!0,clickTimer:"",resultObj:[],lastInput:"",equipmentFormulaLoading:!0,userInputStr:"",isUserInput:!0,rightBoxHeight:0,customUserInput:"",customUserInputObjs:[]}},components:{},computed:{setWidth:function(){return this.width?"number"==typeof this.width?"".concat(this.width,"px"):this.width:"600px"},setCustomSign:function(){return this.customSign||[]},leftViewHeight:function(){return this.testList.length?45*this.testList.length>this.leftBtnsBoxHeight-45?(this.showLeftArrow=!0,this.maxLeftScrollTop=45*this.testList.length-(this.leftBtnsBoxHeight-45),this.leftBtnsBoxHeight-45+"px"):(this.showLeftArrow=!1,"100%"):"100%"},setIcon:function(){return this.arrowState?"arrowdown":"arrowup"},adapted:function(){return this.renameKey||{name:"targetName",id:"id",code:"targetCode",formula:"targetFormula"}},resetresultStr:function(){var t=this;return this.resultStr.map(function(e){return"object"===u(e)?e[t.adapted.name]:e})},setResultStr:function(){return"".concat(this.paramName," = ").concat(this.resetresultStr.join(""))},scrollBarWidth:function(){return this.showLeftArrow?Object(a.m)():0}},watch:{leftScrollTop:function(){var t=this;if(this.scrollSwitch&&this.isClick){var e;this.scrollSwitch=!1,"arrowdown"===this.setIcon?this.animateTimer=setInterval(function(i){e=t.$refs.leftView.scrollTop,t.leftScrollTop>e+10?t.$refs.leftView.scrollTop=e+10:(t.$refs.leftView.scrollTop=t.leftScrollTop,clearInterval(t.animateTimer),t.scrollSwitch=!0,t.$refs.leftView.scrollTop>=t.maxLeftScrollTop&&(t.arrowState=!1))},16.667):this.animateTimer=setInterval(function(i){e=t.$refs.leftView.scrollTop,t.leftScrollTop<e-10?t.$refs.leftView.scrollTop=e-10:(t.$refs.leftView.scrollTop=t.leftScrollTop,clearInterval(t.animateTimer),t.scrollSwitch=!0,t.arrowState=!0)},16.667)}},resetresultStr:function(){this.userInputStr=this.resetresultStr.join("")}},methods:{removeUserInput:function(t,e){var i=this;this.resultStr.splice(e,1),"object"===u(t)&&(this.resultObj=this.resultObj.filter(function(e){return e[i.adapted.id]!==t[i.adapted.id]}))},addUserInput:function(t){this.resultStr.splice(t,0,"")},addUserInputToLast:function(){this.resultStr.push("")},changeVal:function(t){t||(this.customUserInputObjs=[])},setContentStyle:function(t){return this.boldContent.indexOf(t)>-1},setSignStyle:function(t){return this.boldSign.indexOf(t)>-1},setTextStyle:function(t){return"清空"===t||"退格"===t},selectVal:function(t){t&&("清空"===t?this.resultStr=[]:"退格"===t?this.resultStr.length&&this.removeUserSelect(this.resultStr.pop()):(this.resultStr.push(t),this.lastInput=t))},removeUserSelect:function(t){"object"===u(t)&&this.resultObj[this.resultObj.length-1][this.adapted.id]===t[this.adapted.id]&&this.resultObj.pop()},selectObj:function(t){var e=this;this.isUserInput?(this.resultStr.push(t),this.lastInput=t,this.resultObj.push(t)):(this.customUserInputObjs=this.customUserInputObjs.filter(function(i){return i[e.adapted.id]!==t[e.adapted.id]}),this.customUserInputObjs.push(t),this.customUserInput+=t[this.adapted.name])},changeScroll:function(){if(this.isClick=!0,console.log(this.$refs.leftView.scrollTop),this.scrollSwitch){var t=this.maxLeftScrollTop-this.$refs.leftView.scrollTop;t>0?this.leftScrollTop+=t>180?180:t:this.leftScrollTop=0}},leftViewScroll:function(t){var e=this;this.scrollSwitch&&(this.isClick=!1,this.leftScrollTop=t.target.scrollTop,t.target.scrollTop>=this.maxLeftScrollTop?this.arrowState=!1:this.arrowState=!0,clearTimeout(this.clickTimer),this.clickTimer=setTimeout(function(t){e.isClick=!0},100))},getData:function(){this.isUserInput?this.resultStr.length?this.$emit("databridge",{formulaStr:this.setResultStr,resultObj:this.resultObj}):this.$message.error("请先录入公式"):this.customUserInput?this.$emit("databridge",{formulaStr:"".concat(this.paramName," = ").concat(this.customUserInput),resultObj:this.customUserInputObjs}):this.$message.error("请先录入公式")},httpRequests:function(){var t=this;this.$api[this.apiObj.apiName](this.apiObj.params).then(function(e){console.log(e),t.testList=e.EquipmentSensor||[],t.equipmentFormulaLoading=!1}).catch(function(e){t.equipmentFormulaLoading=!1})},edit:function(){this.isUserInput=!this.isUserInput,this.isUserInput||(this.customUserInput="",this.customUserInputObjs=[])}},created:function(){this.apiObj&&this.httpRequests()},mounted:function(){this.leftScrollTop=0,this.leftBtnsBoxHeight=this.$el.querySelector("#leftBtnsBox").offsetHeight,this.rightBoxHeight=this.$refs.equipmentFormula.offsetHeight},beforeDestroy:function(){}},p=(i("Ri2b"),i("KHd+")),d=Object(p.a)(c,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.equipmentFormulaLoading,expression:"equipmentFormulaLoading"}],ref:"equipmentFormula",staticClass:"equipmentFormula",style:{width:this.setWidth}},[i("div",{staticClass:"leftView"},[i("div",{staticStyle:{position:"absolute",top:"0",left:"0",bottom:"0"},style:{right:"-"+t.scrollBarWidth+"px"}},[i("div",{staticStyle:{height:"100%",position:"relative"},attrs:{id:"leftBtnsBox"}},[i("div",{ref:"leftView",staticStyle:{overflow:"auto"},style:{height:t.leftViewHeight},on:{scroll:function(e){t.leftViewScroll(e)}}},[i("div",t._l(t.testList,function(e,a){return i("div",{directives:[{name:"waves",rawName:"v-waves"}],staticClass:"leftBtnViews leftBtns",on:{click:function(i){t.selectObj(e)}}},[i("div",{staticClass:"leftBtnBoxs",domProps:{textContent:t._s(e[t.adapted.name])}})])}))]),t._v(" "),t.showLeftArrow?i("div",{staticClass:"leftArrowBox"},[i("div",{directives:[{name:"waves",rawName:"v-waves"}],staticClass:"leftArrowView leftBtns",style:{width:"calc(100% - "+t.scrollBarWidth+"px)"},on:{click:t.changeScroll}},[i("svg-icon",{attrs:{"icon-class":t.setIcon}})],1)]):t._e()])])]),t._v(" "),i("div",{staticClass:"rightView"},[t.setCustomSign.length?i("div",{staticClass:"customSignView"}):t._e(),t._v(" "),t.isUserInput?i("div",{staticClass:"baseSignView"},t._l(t.baseSign,function(e,a){return i("div",{staticClass:"signView"},[e&&"="!==e?[i("div",{directives:[{name:"waves",rawName:"v-waves"}],staticClass:"signBox isDrop",class:{boldContent:t.setContentStyle(e),boldSign:t.setSignStyle(e),textBtn:t.setTextStyle(e)},on:{click:function(i){t.selectVal(e)}}},[i("div",{staticStyle:{cursor:"default"},domProps:{textContent:t._s(e)}})])]:[i("div",{staticClass:"signBox noDrop",domProps:{textContent:t._s(e)}})]],2)})):t._e(),t._v(" "),i("div",{staticClass:"resultView",style:{height:t.isUserInput?"80px":t.rightBoxHeight+"px"}},[t.isUserInput?i("el-input",{attrs:{placeholder:"请输入内容",disabled:t.isUserInput},model:{value:t.userInputStr,callback:function(e){t.userInputStr=e},expression:"userInputStr"}},[i("template",{slot:"prepend"},[t._v(t._s(t.paramName+" = "))]),t._v(" "),i("el-button",{attrs:{slot:"append",icon:"el-icon-edit",title:"手动编辑公式"},on:{click:t.edit},slot:"append"})],2):i("div",{staticClass:"userInputView"},[i("div",{staticClass:"userInputViewCenter"},[i("el-input",{attrs:{placeholder:"请输入内容"},on:{change:t.changeVal},model:{value:t.customUserInput,callback:function(e){t.customUserInput=e},expression:"customUserInput"}},[i("template",{slot:"prepend"},[t._v(t._s(t.paramName+" = "))]),t._v(" "),i("el-button",{attrs:{slot:"append",icon:"el-icon-edit",title:"关闭手动编辑"},on:{click:t.edit},slot:"append"})],2)],1)])],1)])])},[],!1,null,"9e39096a",null);d.options.__file="index.vue";e.a=d.exports},jUE0:function(t,e,i){},uH3l:function(t,e,i){"use strict";i.r(e);i("rE2o"),i("ioFf"),i("pIFo");var a=i("WZUi");function o(t){return(o="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var s={name:"equipmentFormulaView",components:{equipmentFormula:i("fydv").a},props:["initData","visible"],data:function(){return{dialogLoading:!0,isVisible:!1,inDialog:!0,apiObj:{apiName:"findListEquipmentSensorByEquipment",params:{equipmentId:this.initData.equipmentId}},formulaData:null}},created:function(){},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=o(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){},dialogClose:function(){this.$emit("close-dialog",this.formulaData)},save:function(){this.$refs.equipmentFormula.getData()},databridge:function(t){var e=this,i=t.formulaStr,o=i.substr(i.indexOf("=")+1,i.length-i.indexOf("=")+1),s=o,n=t.resultObj;if(n&&n.length>0)for(var l=n.length,r=0;r<l;r++)if(n[r]){var u=n[r];o=o.replace(u.targetName,"("+u.targetCode+")"),s=s.replace(u.targetName,"("+u.targetFormula+")")}t.targetFormulaDisplay=i,t.targetFormula=o,t.targetFormulaSql=s,this.dialogLoading=!0,Object(a.checkEquipmentSensorFormula)({equipmentId:this.initData.equipmentId,colStr:s,viewStr:""}).then(function(i){e.dialogLoading=!1,0===i.code&&(e.formulaData=t,e.isVisible=!1)}).catch(function(t){e.dialogLoading=!1})}}},n=i("KHd+"),l=Object(n.a)(s,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"",visible:t.isVisible,"append-to-body":"","close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,layoutType:2,width:"672px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}],staticStyle:{padding:"10px","padding-bottom":"0"}},[i("div",{staticStyle:{height:"100%","border-left":"1px solid #e4e4e4","margin-bottom":"10px"}},[i("equipment-formula",{ref:"equipmentFormula",attrs:{width:"650px",apiObj:t.apiObj,paramName:this.initData.targetName},on:{databridge:t.databridge}})],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)])])},[],!1,null,null,null);l.options.__file="dialogEquipmentFormula.vue";e.default=l.exports},uas5:function(t,e,i){},ylDV:function(t,e,i){"use strict";i.r(e);i("rE2o"),i("ioFf");var a=i("uH3l"),o=i("WZUi");function s(t){return(s="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var n={components:{dialogEquipmentFormula:a.default},name:"dialog-add",props:["initData","visible"],data:function(){return{isShowTargetFormula:!1,rules:{targetName:[{required:!0,message:"请填写指标名称",trigger:"change"}]},openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:""},dialogLoading:!0,isVisible:!1,inDialog:!0,formData:{equipmentId:"",targetType:"",targetName:"",targetFormula:"",targetFormulaSql:"",targetFormulaDisplay:"",remark:""},formulaData:null}},created:function(){this.formData.targetType="A",this.isShowTargetFormula=!1,this.formData.equipmentId=this.initData.equipmentId},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=s(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dataBridge:function(t){},dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},deleteBtns:function(t,e){this.tableData.splice(e,1)},closeDialog:function(t){this.inLinVisible=!1,this.showDialog=!1,this.formulaData=t,this.formData.targetFormulaDisplay=t.targetFormulaDisplay,this.formData.targetFormula=t.targetFormula,this.formData.targetFormulaSql=t.targetFormulaSql},openFormula:function(){this.formData.targetName?(this.dialogData.equipmentId=this.initData.equipmentId,this.dialogData.targetName=this.formData.targetName,this.dialogData.title="设置公式",this.openDialogName="dialogEquipmentFormula",this.showDialog=!0,this.inLinVisible=!0):this.$message({type:"warning",duration:5e3,showClose:!0,message:"请先填写指标名称！"})},save:function(){var t=this;this.$refs.submitForm.validate(function(e){e&&(t.dialogLoading=!0,Object(o.addEquipmentSensor)(t.formData).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){t.dialogLoading=!1}))})},selectChange:function(){this.isShowTargetFormula=!1,"B"==this.formData.targetType&&(this.isShowTargetFormula=!0)}},watch:{}},l=i("KHd+"),r=Object(l.a)(n,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"350px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}],staticStyle:{"margin-top":"20px"}},[i("el-form",{ref:"submitForm",staticStyle:{margin:"10px auto",width:"100%"},attrs:{rules:t.rules,model:t.formData,"label-position":"right","label-width":"120px"}},[i("el-row",[i("el-form-item",{attrs:{label:"指标类型:",prop:"targetType"}},[i("el-select",{staticStyle:{width:"200px"},on:{change:t.selectChange},model:{value:t.formData.targetType,callback:function(e){t.$set(t.formData,"targetType",e)},expression:"formData.targetType"}},[i("el-option",{attrs:{label:"传感器指标",value:"A"}}),t._v(" "),i("el-option",{attrs:{label:"分析指标",value:"B"}})],1)],1)],1),t._v(" "),i("el-row",[i("el-form-item",{attrs:{label:"指标名称:",prop:"targetName"}},[i("el-input",{staticStyle:{width:"200px"},model:{value:t.formData.targetName,callback:function(e){t.$set(t.formData,"targetName",e)},expression:"formData.targetName"}})],1)],1),t._v(" "),i("el-row",{directives:[{name:"show",rawName:"v-show",value:t.isShowTargetFormula,expression:"isShowTargetFormula"}]},[i("el-form-item",{attrs:{label:"指标公式:",prop:"targetFormula"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{type:"textarea",rows:"2",disabled:!0},model:{value:t.formData.targetFormulaDisplay,callback:function(e){t.$set(t.formData,"targetFormulaDisplay",e)},expression:"formData.targetFormulaDisplay"}}),t._v(" "),i("el-button",{attrs:{type:"text",icon:"el-icon-plus"},on:{click:t.openFormula}},[t._v("公式编辑器")])],1)],1),t._v(" "),i("el-row",[i("el-form-item",{attrs:{label:"备注:",prop:"remark"}},[i("el-input",{staticStyle:{width:"200px"},attrs:{type:"textarea",rows:"2"},model:{value:t.formData.remark,callback:function(e){t.$set(t.formData,"remark",e)},expression:"formData.remark"}})],1)],1)],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,null,null);r.options.__file="dialogAdd.vue";e.default=r.exports}}]);