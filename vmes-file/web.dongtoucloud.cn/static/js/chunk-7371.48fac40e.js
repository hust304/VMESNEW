(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-7371"],{LXPs:function(t,e,s){"use strict";s.r(e);var i={name:"equipmentFormulaView",components:{equipmentFormula:s("fydv").a},data:function(){return{apiObj:{apiName:"findListEquipmentSensorByEquipment",params:{equipmentId:"70e6f68a2e3844e3afac64c56c7f34c5"}},formulaData:null}},methods:{getData:function(){this.$refs.equipmentFormula.getData()},databridge:function(t){this.formulaData=t}}},n=s("KHd+"),r=Object(n.a)(i,function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{staticClass:"equipmentFormulaView"},[s("equipment-formula",{ref:"equipmentFormula",attrs:{width:"650px",apiObj:t.apiObj,paramName:"用户输入的"},on:{databridge:t.databridge}}),t._v(" "),s("el-row",{attrs:{gutter:10}},[s("el-button",{attrs:{type:"primary"},on:{click:t.getData}},[t._v("获取公式对象")]),t._v(" "),s("p",{domProps:{textContent:t._s("公式："+(t.formulaData?t.formulaData.formulaStr:""))}})],1)],1)},[],!1,null,null,null);r.options.__file="index.vue";e.default=r.exports},Ri2b:function(t,e,s){"use strict";var i=s("uas5");s.n(i).a},fydv:function(t,e,s){"use strict";s("rE2o"),s("ioFf"),s("f3/d"),s("xfY5");var i=s("z0WU"),n=(s("91GP"),s("jUE0"),s("QWlu")),r="@@wavesContext";function o(t,e){function s(s){var i=Object.assign({},e.value),n=Object.assign({ele:t,type:"hit",color:"rgba(0, 0, 0, 0.15)"},i),r=n.ele;if(r){r.style.position="relative",r.style.overflow="hidden";var o=r.getBoundingClientRect(),l=r.querySelector(".waves-ripple");switch(l?l.className="waves-ripple":((l=document.createElement("span")).className="waves-ripple",l.style.height=l.style.width=Math.max(o.width,o.height)+"px",r.appendChild(l)),n.type){case"center":l.style.top=o.height/2-l.offsetHeight/2+"px",l.style.left=o.width/2-l.offsetWidth/2+"px";break;default:l.style.top=(s.pageY-o.top-l.offsetHeight/2-document.documentElement.scrollTop||document.body.scrollTop)+"px",l.style.left=(s.pageX-o.left-l.offsetWidth/2-document.documentElement.scrollLeft||document.body.scrollLeft)+"px"}return l.style.backgroundColor=n.color,l.className="waves-ripple z-active",!1}}return t[r]?t[r].removeHandle=s:t[r]={removeHandle:s},s}var l={bind:function(t,e){n.a.on(t,"click",o(t,e))},update:function(t,e){n.a.off(t,"click",t[r].removeHandle),n.a.on(t,"click",o(t,e))},unbind:function(t){n.a.off(t,"click",t[r].removeHandle),t[r]=null,delete t[r]}},a=function(t){t.directive("waves",l)};function u(t){return(u="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}window.Vue&&(window.waves=l,Vue.use(a)),l.install=a;var c={name:"equipment-formula",props:{width:[String,Number],customSign:{type:Array,default:function(){return[]}},renameKey:{type:Object,default:function(){return null}},apiObj:{type:Object,default:function(){return null}},paramName:{type:String,default:""}},directives:{waves:l},data:function(){return{testList:[],baseSign:["7","8","9","+","4","5","6","-","1","2","3","*","(","0",".","/",")","退格","清空","="],boldContent:["7","8","9","4","5","6","1","2","3","0","."],boldSign:["+","-","*","/","=","(",")"],resultStr:[],leftBtnsBoxHeight:0,showLeftArrow:!1,leftScrollTop:0,maxLeftScrollTop:0,scrollSwitch:!0,animateTimer:"",arrowState:!0,isClick:!0,clickTimer:"",resultObj:[],lastInput:"",equipmentFormulaLoading:!0,userInputStr:"",isUserInput:!0,rightBoxHeight:0,customUserInput:"",customUserInputObjs:[]}},components:{},computed:{setWidth:function(){return this.width?"number"==typeof this.width?"".concat(this.width,"px"):this.width:"600px"},setCustomSign:function(){return this.customSign||[]},leftViewHeight:function(){return this.testList.length?45*this.testList.length>this.leftBtnsBoxHeight-45?(this.showLeftArrow=!0,this.maxLeftScrollTop=45*this.testList.length-(this.leftBtnsBoxHeight-45),this.leftBtnsBoxHeight-45+"px"):(this.showLeftArrow=!1,"100%"):"100%"},setIcon:function(){return this.arrowState?"arrowdown":"arrowup"},adapted:function(){return this.renameKey||{name:"targetName",id:"id",code:"targetCode",formula:"targetFormula"}},resetresultStr:function(){var t=this;return this.resultStr.map(function(e){return"object"===u(e)?e[t.adapted.name]:e})},setResultStr:function(){return"".concat(this.paramName," = ").concat(this.resetresultStr.join(""))},scrollBarWidth:function(){return this.showLeftArrow?Object(i.o)():0}},watch:{leftScrollTop:function(){var t=this;if(this.scrollSwitch&&this.isClick){var e;this.scrollSwitch=!1,"arrowdown"===this.setIcon?this.animateTimer=setInterval(function(s){e=t.$refs.leftView.scrollTop,t.leftScrollTop>e+10?t.$refs.leftView.scrollTop=e+10:(t.$refs.leftView.scrollTop=t.leftScrollTop,clearInterval(t.animateTimer),t.scrollSwitch=!0,t.$refs.leftView.scrollTop>=t.maxLeftScrollTop&&(t.arrowState=!1))},16.667):this.animateTimer=setInterval(function(s){e=t.$refs.leftView.scrollTop,t.leftScrollTop<e-10?t.$refs.leftView.scrollTop=e-10:(t.$refs.leftView.scrollTop=t.leftScrollTop,clearInterval(t.animateTimer),t.scrollSwitch=!0,t.arrowState=!0)},16.667)}},resetresultStr:function(){this.userInputStr=this.resetresultStr.join("")}},methods:{removeUserInput:function(t,e){var s=this;this.resultStr.splice(e,1),"object"===u(t)&&(this.resultObj=this.resultObj.filter(function(e){return e[s.adapted.id]!==t[s.adapted.id]}))},addUserInput:function(t){this.resultStr.splice(t,0,"")},addUserInputToLast:function(){this.resultStr.push("")},changeVal:function(t){t||(this.customUserInputObjs=[])},setContentStyle:function(t){return this.boldContent.indexOf(t)>-1},setSignStyle:function(t){return this.boldSign.indexOf(t)>-1},setTextStyle:function(t){return"清空"===t||"退格"===t},selectVal:function(t){t&&("清空"===t?this.resultStr=[]:"退格"===t?this.resultStr.length&&this.removeUserSelect(this.resultStr.pop()):(this.resultStr.push(t),this.lastInput=t))},removeUserSelect:function(t){"object"===u(t)&&this.resultObj[this.resultObj.length-1][this.adapted.id]===t[this.adapted.id]&&this.resultObj.pop()},selectObj:function(t){var e=this;this.isUserInput?(this.resultStr.push(t),this.lastInput=t,this.resultObj.push(t)):(this.customUserInputObjs=this.customUserInputObjs.filter(function(s){return s[e.adapted.id]!==t[e.adapted.id]}),this.customUserInputObjs.push(t),this.customUserInput+=t[this.adapted.name])},changeScroll:function(){if(this.isClick=!0,console.log(this.$refs.leftView.scrollTop),this.scrollSwitch){var t=this.maxLeftScrollTop-this.$refs.leftView.scrollTop;t>0?this.leftScrollTop+=t>180?180:t:this.leftScrollTop=0}},leftViewScroll:function(t){var e=this;this.scrollSwitch&&(this.isClick=!1,this.leftScrollTop=t.target.scrollTop,t.target.scrollTop>=this.maxLeftScrollTop?this.arrowState=!1:this.arrowState=!0,clearTimeout(this.clickTimer),this.clickTimer=setTimeout(function(t){e.isClick=!0},100))},getData:function(){this.isUserInput?this.resultStr.length?this.$emit("databridge",{formulaStr:this.setResultStr,resultObj:this.resultObj}):this.$message.error("请先录入公式"):this.customUserInput?this.$emit("databridge",{formulaStr:"".concat(this.paramName," = ").concat(this.customUserInput),resultObj:this.customUserInputObjs}):this.$message.error("请先录入公式")},httpRequests:function(){var t=this;this.$api[this.apiObj.apiName](this.apiObj.params).then(function(e){console.log(e),t.testList=e.EquipmentSensor||[],t.equipmentFormulaLoading=!1}).catch(function(e){t.equipmentFormulaLoading=!1})},edit:function(){this.isUserInput=!this.isUserInput,this.isUserInput||(this.customUserInput="",this.customUserInputObjs=[])}},created:function(){this.apiObj&&this.httpRequests()},mounted:function(){this.leftScrollTop=0,this.leftBtnsBoxHeight=this.$el.querySelector("#leftBtnsBox").offsetHeight,this.rightBoxHeight=this.$refs.equipmentFormula.offsetHeight},beforeDestroy:function(){}},p=(s("Ri2b"),s("KHd+")),h=Object(p.a)(c,function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{directives:[{name:"loading",rawName:"v-loading",value:t.equipmentFormulaLoading,expression:"equipmentFormulaLoading"}],ref:"equipmentFormula",staticClass:"equipmentFormula",style:{width:this.setWidth}},[s("div",{staticClass:"leftView"},[s("div",{staticStyle:{position:"absolute",top:"0",left:"0",bottom:"0"},style:{right:"-"+t.scrollBarWidth+"px"}},[s("div",{staticStyle:{height:"100%",position:"relative"},attrs:{id:"leftBtnsBox"}},[s("div",{ref:"leftView",staticStyle:{overflow:"auto"},style:{height:t.leftViewHeight},on:{scroll:function(e){t.leftViewScroll(e)}}},[s("div",t._l(t.testList,function(e,i){return s("div",{directives:[{name:"waves",rawName:"v-waves"}],staticClass:"leftBtnViews leftBtns",on:{click:function(s){t.selectObj(e)}}},[s("div",{staticClass:"leftBtnBoxs",domProps:{textContent:t._s(e[t.adapted.name])}})])}))]),t._v(" "),t.showLeftArrow?s("div",{staticClass:"leftArrowBox"},[s("div",{directives:[{name:"waves",rawName:"v-waves"}],staticClass:"leftArrowView leftBtns",style:{width:"calc(100% - "+t.scrollBarWidth+"px)"},on:{click:t.changeScroll}},[s("svg-icon",{attrs:{"icon-class":t.setIcon}})],1)]):t._e()])])]),t._v(" "),s("div",{staticClass:"rightView"},[t.setCustomSign.length?s("div",{staticClass:"customSignView"}):t._e(),t._v(" "),t.isUserInput?s("div",{staticClass:"baseSignView"},t._l(t.baseSign,function(e,i){return s("div",{staticClass:"signView"},[e&&"="!==e?[s("div",{directives:[{name:"waves",rawName:"v-waves"}],staticClass:"signBox isDrop",class:{boldContent:t.setContentStyle(e),boldSign:t.setSignStyle(e),textBtn:t.setTextStyle(e)},on:{click:function(s){t.selectVal(e)}}},[s("div",{staticStyle:{cursor:"default"},domProps:{textContent:t._s(e)}})])]:[s("div",{staticClass:"signBox noDrop",domProps:{textContent:t._s(e)}})]],2)})):t._e(),t._v(" "),s("div",{staticClass:"resultView",style:{height:t.isUserInput?"80px":t.rightBoxHeight+"px"}},[t.isUserInput?s("el-input",{attrs:{placeholder:"请输入内容",disabled:t.isUserInput},model:{value:t.userInputStr,callback:function(e){t.userInputStr=e},expression:"userInputStr"}},[s("template",{slot:"prepend"},[t._v(t._s(t.paramName+" = "))]),t._v(" "),s("el-button",{attrs:{slot:"append",icon:"el-icon-edit",title:"手动编辑公式"},on:{click:t.edit},slot:"append"})],2):s("div",{staticClass:"userInputView"},[s("div",{staticClass:"userInputViewCenter"},[s("el-input",{attrs:{placeholder:"请输入内容"},on:{change:t.changeVal},model:{value:t.customUserInput,callback:function(e){t.customUserInput=e},expression:"customUserInput"}},[s("template",{slot:"prepend"},[t._v(t._s(t.paramName+" = "))]),t._v(" "),s("el-button",{attrs:{slot:"append",icon:"el-icon-edit",title:"关闭手动编辑"},on:{click:t.edit},slot:"append"})],2)],1)])],1)])])},[],!1,null,"9e39096a",null);h.options.__file="index.vue";e.a=h.exports},jUE0:function(t,e,s){},uas5:function(t,e,s){}}]);