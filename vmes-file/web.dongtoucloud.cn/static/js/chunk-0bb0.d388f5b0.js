(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-0bb0"],{"+FrK":function(e,t,n){"use strict";var i=n("M1cD");n.n(i).a},"+PAC":function(e,t,n){"use strict";var i=n("hwje");n.n(i).a},M1cD:function(e,t,n){},MngD:function(e,t,n){"use strict";n("rGqo"),n("yt8O"),n("RW0V"),n("KKXr");function i(e){for(var t=1;t<arguments.length;t++){var n=null!=arguments[t]?arguments[t]:{},i=Object.keys(n);"function"==typeof Object.getOwnPropertySymbols&&(i=i.concat(Object.getOwnPropertySymbols(n).filter(function(e){return Object.getOwnPropertyDescriptor(n,e).enumerable}))),i.forEach(function(t){a(e,t,n[t])})}return e}function a(e,t,n){return t in e?Object.defineProperty(e,t,{value:n,enumerable:!0,configurable:!0,writable:!0}):e[t]=n,e}var o={name:"EditShape",props:{active:{type:Boolean,default:!1},defaultStyle:{require:!0,type:Object},data:{type:Object,default:function(){return null}},uuid:String,showOnly:{type:Boolean,default:!1}},data:function(){return{pointList:["lt","rt","lb","rb","l","r","t","b"],directionKey:{t:"n",b:"s",l:"w",r:"e"}}},created:function(){},mounted:function(){},methods:{getPointStyle:function(e){var t=this;if(!this.showOnly){var n=this.defaultStyle,i=n.height,a=n.width,o=/t/.test(e),r=/b/.test(e),u=/l/.test(e),l=/r/.test(e),c=0,s=0;return 2===e.length?(c=u?0:a,s=o?0:i):((o||r)&&(c=a/2-("t"===e||"b"===e?5:0),s=o?0:i),(u||l)&&(c=u?0:a,s=i/2-("l"===e||"r"===e?5:0))),{marginLeft:u||l?"-5px":0,marginTop:o||r?"-5px":0,left:"".concat(c,"px"),top:"".concat(s,"px"),cursor:e.split("").reverse().map(function(e){return t.directionKey[e]}).join("")+"-resize"}}},handleTopWrapperClick:function(e){e.stopPropagation(),e.preventDefault()},handleMouseDownOnElement:function(e){var t=this;if(!this.showOnly){this.$emit("handleElementClick",this.uuid);var n,a=i({},this.defaultStyle),o=e.clientY,r=e.clientX,u=a.top,l=a.left;n=(new Date).getTime();var c=function(e){e.stopPropagation(),e.preventDefault();var n=e.clientX,i=e.clientY;a.top=i-o+u,a.left=n-r+l,t.$emit("resize",a)};return document.addEventListener("mousemove",c,!0),document.addEventListener("mouseup",function e(){(new Date).getTime()-n>200&&t.$emit("resize"),document.removeEventListener("mousemove",c,!0),document.removeEventListener("mouseup",e,!0)},!0),!0}},handleMouseDownOnPoint:function(e){var t=this;if(!this.showOnly){var n=event;this.$emit("handleElementClick",this.uuid),n.stopPropagation(),n.preventDefault();var a=i({},this.defaultStyle),o=a.height,r=a.width,u=a.top,l=a.left,c=n.clientX,s=n.clientY,m=function(n){var i=n.clientX,m=n.clientY-s,d=i-c,f=/t/.test(e),p=/b/.test(e),v=/l/.test(e),h=/r/.test(e),g=+o+(f?-m:p?m:0),b=+r+(v?-d:h?d:0);a.height=g>0?g:0,a.width=b>0?b:0,a.left=+l+(v?d:0),a.top=+u+(f?m:0),t.$emit("resize",a)};document.addEventListener("mousemove",m),document.addEventListener("mouseup",function e(){t.$emit("resize"),document.removeEventListener("mousemove",m),document.removeEventListener("mouseup",e)})}},escUserSelectComponents:function(){this.showOnly||this.active&&this.$emit("reset-active",{uuid:this.uuid,type:this.data.type})},deleteUserSelectComponents:function(){this.showOnly||this.active&&this.$emit("delete-active",this.uuid)}}},r=(n("YYQC"),n("KHd+")),u=Object(r.a)(o,function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"components-edit-shape",class:{active:this.active},attrs:{tabindex:"0"},on:{click:e.handleTopWrapperClick,mousedown:e.handleMouseDownOnElement,keyup:[function(t){return"button"in t||!e._k(t.keyCode,"esc",27,t.key,["Esc","Escape"])?e.escUserSelectComponents(t):null},function(t){return"button"in t||46===t.keyCode?e.deleteUserSelectComponents(t):null}]}},[e._l(e.active?e.pointList:[],function(t){return n("div",{key:t,staticClass:"edit-shape-point",style:e.getPointStyle(t),on:{mousedown:function(n){e.handleMouseDownOnPoint(t)}}})}),e._v(" "),e._t("default")],2)},[],!1,null,"6728bc4e",null);u.options.__file="editShape.vue";t.a=u.exports},TB3a:function(e,t,n){"use strict";n("a1Th"),n("SRfc"),n("KKXr");t.a={timeStamp:function(e){if("string"==typeof e){var t=e.split(" ");if(1===t.length){var n=t[0].match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);return null===n?(new Date).getTime():new Date(n[1],n[3]-1,n[4]).getTime()}var i=t[0].match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/),a=t[1].match(/^(\d{1,2})(-|\:)(\d{1,2})\2(\d{1,2})$/);return i&&a?new Date(i[1],i[3]-1,i[4],a[1],a[3],a[4]).getTime():(new Date).getTime()}return"number"==typeof e?864e5*e:(new Date).getTime()},formatDate:function(e,t){var n=e?new Date(e):new Date,i=n.getFullYear(),a=n.getMonth()+1,o=n.getDate(),r=n.getHours(),u=n.getMinutes(),l=n.getSeconds(),c=function(e){return(e=e.toString())[1]?e:"0"+e};return[i,a,o].map(c).join(t||"-")+" "+[r,u,l].map(c).join(":")}}},"W2P+":function(e,t,n){},YYQC:function(e,t,n){"use strict";var i=n("i0wH");n.n(i).a},YhG6:function(e,t,n){},"bWZ/":function(e,t,n){"use strict";var i=n("fQ+J");n.n(i).a},cSvC:function(e,t,n){"use strict";var i=n("W2P+");n.n(i).a},"fQ+J":function(e,t,n){},hwje:function(e,t,n){},i0wH:function(e,t,n){},i6nb:function(e,t,n){"use strict";var i=n("jEHv");n.n(i).a},jEHv:function(e,t,n){},jq09:function(e,t,n){"use strict";n("rGqo"),n("yt8O"),n("RW0V"),n("Z2Ku");var i=n("z0WU"),a=n("LvDl");function o(e){for(var t=1;t<arguments.length;t++){var n=null!=arguments[t]?arguments[t]:{},i=Object.keys(n);"function"==typeof Object.getOwnPropertySymbols&&(i=i.concat(Object.getOwnPropertySymbols(n).filter(function(e){return Object.getOwnPropertyDescriptor(n,e).enumerable}))),i.forEach(function(t){r(e,t,n[t])})}return e}function r(e,t,n){return t in e?Object.defineProperty(e,t,{value:n,enumerable:!0,configurable:!0,writable:!0}):e[t]=n,e}var u={elName:"",animations:[],commonStyle:{position:"absolute",width:300,height:30,top:200,left:0,rotate:0,paddingTop:0,paddingLeft:0,paddingRight:0,paddingBottom:0,marginTop:0,marginLeft:0,marginRight:0,marginBottom:0,borderWidth:0,borderColor:"",borderStyle:"solid",borderRadius:0,boxShadow:"",fontSize:16,fontWeight:500,lineHeight:1.4,letterSpacing:0,textAlign:"center",color:"#000000",backgroundColor:"",backgroundImage:"",backgroundSize:"cover",opacity:1,zIndex:1},events:[],propsValue:{},value:"",valueType:"String"},l={name:"",elements:[],commonStyle:{backgroundColor:"",backgroundImage:"",backgroundSize:"cover"},config:{}},c={name:"",title:"未命名场景",description:"我用夸克可视化编辑器做了一个超酷炫的H5，快来看看吧。",coverImage:"",auther:"",script:"",width:300,height:300,pages:[]},s=function(e){var t=arguments.length>1&&void 0!==arguments[1]?arguments[1]:{};return(e=Object(a.cloneDeep)(e)).uuid=Object(i.f)(),e.commonStyle=Object(a.merge)(e.commonStyle,t),e.commonStyle.top=e.commonStyle.top+10,e.commonStyle.left=e.commonStyle.left+10,e},m=function(){return o({uuid:Object(i.f)()},Object(a.cloneDeep)(l))};t.a={elementConfig:u,pageConfig:l,projectConfig:c,getElementConfig:function(e){var t=arguments.length>1&&void 0!==arguments[1]?arguments[1]:{},n=Object(a.cloneDeep)(e),r=n.valueType||"String",l=Object(a.cloneDeep)(u),c=o({uuid:Object(i.f)()},l,{elName:n.elName,propsValue:Object(i.h)(n.needProps||{})});return c.commonStyle=Object(a.merge)(c.commonStyle,n.defaultStyle),c.commonStyle=Object(a.merge)(c.commonStyle,t),c.value=e.defaultValue||{Sting:"",Array:[],Object:{},Boolean:!1,Number:0}[r],c.valueType=r,c.isForm=!!e.isForm,c},getPageConfig:m,getProjectConfig:function(){var e=Object(a.cloneDeep)(c),t=m();return e.pages.push(o({},t)),o({},e)},copyPage:function(e){var t=Object(a.cloneDeep)(e);return t.uuid=Object(i.f)(),t.elements=t.elements.map(function(e){return s(e)}),t},copyElement:s,getCommonStyle:function(e){var t=arguments.length>1&&void 0!==arguments[1]?arguments[1]:1,n=["width","height","top","left","paddingTop","paddingLeft","paddingRight","paddingBottom","marginTop","marginLeft","marginRight","marginBottom","borderWidth","fontSize","borderRadius","letterSpacing"],i={};for(var a in e)n.includes(a)?i[a]=e[a]*t+"px":i[a]=e[a];return i.transform="rotate(".concat(i.rotate,"deg)"),i.backgroundImage=i.backgroundImage?"url(".concat(i.backgroundImage,")"):"",i}}},"y+pX":function(e,t,n){"use strict";var i=n("YhG6");n.n(i).a},z1Gy:function(e,t,n){"use strict";n("rGqo"),n("f3/d");var i={name:"QkImage",props:{imageSrc:{type:String,default:"http://seopic.699pic.com/photo/50051/4111.jpg_wh1200.jpg"}}},a=(n("bWZ/"),n("KHd+")),o=Object(a.a)(i,function(){var e=this.$createElement,t=this._self._c||e;return t("div",{staticClass:"qk-image"},[t("img",{attrs:{src:this.imageSrc,alt:""}})])},[],!1,null,"2e624220",null);o.options.__file="index.vue";var r=o.exports;r.install=function(e){e.component(r.name,r)};var u=r,l=(n("KKXr"),n("TB3a")),c={name:"QkDate",props:{value:{type:String,default:""},item:{type:Object,default:function(){return null}}},data:function(){return{dateValue:"",dateTimer:""}},created:function(){var e=this;this.dateValue=l.a.formatDate().split(" ")[0];var t=864e5+60*(new Date).getTimezoneOffset()*1e3-((new Date).getTime()-new Date(this.dateValue).getTime());this.dateTimer=setTimeout(function(t){e.dateValue=l.a.formatDate().split(" ")[0]},t)},beforeDestroy:function(){clearTimeout(this.dateTimer)}},s=(n("cSvC"),Object(a.a)(c,function(){var e=this.$createElement;return(this._self._c||e)("div",{staticClass:"qk-date",domProps:{textContent:this._s(this.dateValue)}})},[],!1,null,"0a731891",null));s.options.__file="index.vue";var m=s.exports;m.install=function(e){e.component(m.name,m)};var d=m,f={name:"QkDatetime",props:{value:{type:String,default:""},item:{type:Object,default:function(){return null}}},data:function(){return{dateValue:"",dateTimer:""}},created:function(){var e=this;this.dateValue=l.a.formatDate(),this.dateTimer=setInterval(function(t){e.dateValue=l.a.formatDate()},1e3)},beforeDestroy:function(){clearInterval(this.dateTimer)}},p=(n("y+pX"),Object(a.a)(f,function(){var e=this.$createElement;return(this._self._c||e)("div",{staticClass:"qk-datetime",domProps:{textContent:this._s(this.dateValue)}})},[],!1,null,"8e1adfbc",null));p.options.__file="index.vue";var v=p.exports;v.install=function(e){e.component(v.name,v)};var h=v,g={name:"QkTime",props:{value:{type:String,default:""},item:{type:Object,default:function(){return null}}},data:function(){return{timeValue:"",dateTimer:""}},created:function(){var e=this;this.timeValue=l.a.formatDate().split(" ")[1],this.dateTimer=setInterval(function(t){e.timeValue=l.a.formatDate().split(" ")[1]},1e3)},beforeDestroy:function(){clearInterval(this.dateTimer)}},b=(n("i6nb"),Object(a.a)(g,function(){var e=this.$createElement;return(this._self._c||e)("div",{staticClass:"qk-time",domProps:{textContent:this._s(this.timeValue)}})},[],!1,null,"726f3bfc",null));b.options.__file="index.vue";var y=b.exports;y.install=function(e){e.component(y.name,y)};var w=y,O={name:"QkInput",props:{value:{type:String,default:""},readonly:{type:Boolean,default:!1},item:{type:Object,default:function(){return null}}},data:function(){return{userValue:this.value}},watch:{userValue:function(){this.$emit("value-bus",{value:this.userValue,uuid:this.item.uuid})}}},S=(n("+PAC"),Object(a.a)(O,function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"qk-input"},[n("input",{directives:[{name:"model",rawName:"v-model",value:e.userValue,expression:"userValue"}],staticClass:"qk-input-item",attrs:{placeholder:"请输入",type:"text",readonly:e.readonly},domProps:{value:e.userValue},on:{input:function(t){t.target.composing||(e.userValue=t.target.value)}}})])},[],!1,null,"fbc0ec80",null));S.options.__file="index.vue";var j=S.exports;j.install=function(e){e.component(j.name,j)};var D=j,k={name:"QkTextarea",props:{value:{require:!1},readonly:{type:Boolean,default:!1},item:{type:Object,default:function(){return null}}},data:function(){return{tempValue:this.value}},watch:{tempValue:function(){this.$emit("value-bus",{value:this.tempValue,uuid:this.item.uuid})}}},C=(n("+FrK"),Object(a.a)(k,function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"qk-textarea"},[n("textarea",{directives:[{name:"model",rawName:"v-model",value:e.tempValue,expression:"tempValue"}],staticClass:"qk-textarea-item",style:{width:e.item.defaultStyle.width+"px",height:e.item.defaultStyle.height+"px"},attrs:{placeholder:"请输入",readonly:e.readonly},domProps:{value:e.tempValue},on:{input:function(t){t.target.composing||(e.tempValue=t.target.value)}}})])},[],!1,null,"66e54828",null));C.options.__file="index.vue";var T=C.exports;T.install=function(e){e.component(T.name,T)};var _=T;n.d(t,"a",function(){return E});var x=[u,d,h,w,D,_],V=function e(t){e.installed||(e.installed=!0,x.map(function(e){return t.component(e.name,e)}))};"undefined"!=typeof window&&window.Vue&&V(window.Vue);var E={};x.forEach(function(e){E[e.name]=e})}}]);