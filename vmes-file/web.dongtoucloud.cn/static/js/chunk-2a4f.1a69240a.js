(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-2a4f"],{"+Jge":function(e,t,a){},"/uea":function(e,t,a){},"1H0o":function(e,t,a){"use strict";var r=a("Witu");a.n(r).a},B7Ix:function(e,t,a){"use strict";var r=a("oeZg");a.n(r).a},EiiD:function(e,t,a){},MngD:function(e,t,a){"use strict";a("rGqo"),a("yt8O"),a("RW0V"),a("KKXr");function r(e){for(var t=1;t<arguments.length;t++){var a=null!=arguments[t]?arguments[t]:{},r=Object.keys(a);"function"==typeof Object.getOwnPropertySymbols&&(r=r.concat(Object.getOwnPropertySymbols(a).filter(function(e){return Object.getOwnPropertyDescriptor(a,e).enumerable}))),r.forEach(function(t){d(e,t,a[t])})}return e}function d(e,t,a){return t in e?Object.defineProperty(e,t,{value:a,enumerable:!0,configurable:!0,writable:!0}):e[t]=a,e}var c={name:"EditShape",props:{active:{type:Boolean,default:!1},defaultStyle:{require:!0,type:Object},data:{type:Object,default:function(){return null}},uuid:String,showOnly:{type:Boolean,default:!1}},data:function(){return{pointList:["lt","rt","lb","rb","l","r","t","b"],directionKey:{t:"n",b:"s",l:"w",r:"e"}}},created:function(){},mounted:function(){},methods:{getPointStyle:function(e){var t=this;if(!this.showOnly){var a=this.defaultStyle,r=a.height,d=a.width,c=/t/.test(e),u=/b/.test(e),o=/l/.test(e),n=/r/.test(e),i=0,s=0;return 2===e.length?(i=o?0:d,s=c?0:r):((c||u)&&(i=d/2-("t"===e||"b"===e?5:0),s=c?0:r),(o||n)&&(i=o?0:d,s=r/2-("l"===e||"r"===e?5:0))),{marginLeft:o||n?"-5px":0,marginTop:c||u?"-5px":0,left:"".concat(i,"px"),top:"".concat(s,"px"),cursor:e.split("").reverse().map(function(e){return t.directionKey[e]}).join("")+"-resize"}}},handleTopWrapperClick:function(e){e.stopPropagation(),e.preventDefault()},handleMouseDownOnElement:function(e){var t=this;if(!this.showOnly){this.$emit("handleElementClick",this.uuid);var a,d=r({},this.defaultStyle),c=e.clientY,u=e.clientX,o=d.top,n=d.left;a=(new Date).getTime();var i=function(e){e.stopPropagation(),e.preventDefault();var a=e.clientX,r=e.clientY;d.top=r-c+o,d.left=a-u+n,t.$emit("resize",d)};return document.addEventListener("mousemove",i,!0),document.addEventListener("mouseup",function e(){(new Date).getTime()-a>200&&t.$emit("resize"),document.removeEventListener("mousemove",i,!0),document.removeEventListener("mouseup",e,!0)},!0),!0}},handleMouseDownOnPoint:function(e){var t=this;if(!this.showOnly){var a=event;this.$emit("handleElementClick",this.uuid),a.stopPropagation(),a.preventDefault();var d=r({},this.defaultStyle),c=d.height,u=d.width,o=d.top,n=d.left,i=a.clientX,s=a.clientY,p=function(a){var r=a.clientX,p=a.clientY-s,f=r-i,l=/t/.test(e),b=/b/.test(e),m=/l/.test(e),h=/r/.test(e),g=+c+(l?-p:b?p:0),v=+u+(m?-f:h?f:0);d.height=g>0?g:0,d.width=v>0?v:0,d.left=+n+(m?f:0),d.top=+o+(l?p:0),t.$emit("resize",d)};document.addEventListener("mousemove",p),document.addEventListener("mouseup",function e(){t.$emit("resize"),document.removeEventListener("mousemove",p),document.removeEventListener("mouseup",e)})}},escUserSelectComponents:function(){this.showOnly||this.active&&this.$emit("reset-active",{uuid:this.uuid,type:this.data.type})},deleteUserSelectComponents:function(){this.showOnly||this.active&&this.$emit("delete-active",this.uuid)}}},u=(a("uVyu"),a("KHd+")),o=Object(u.a)(c,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"components-edit-shape",class:{active:this.active},attrs:{tabindex:"0"},on:{click:e.handleTopWrapperClick,mousedown:e.handleMouseDownOnElement,keyup:[function(t){return"button"in t||!e._k(t.keyCode,"esc",27,t.key,["Esc","Escape"])?e.escUserSelectComponents(t):null},function(t){return"button"in t||46===t.keyCode?e.deleteUserSelectComponents(t):null}]}},["custom"!==e.data.type?e._l(e.active?e.pointList:[],function(t){return a("div",{key:t,staticClass:"edit-shape-point",style:e.getPointStyle(t),on:{mousedown:function(a){e.handleMouseDownOnPoint(t)}}})}):e._e(),e._v(" "),e._t("default")],2)},[],!1,null,"7e868dae",null);o.options.__file="editShape.vue";t.a=o.exports},PM9h:function(e,t,a){"use strict";var r=a("/uea");a.n(r).a},TB3a:function(e,t,a){"use strict";a("a1Th"),a("SRfc"),a("KKXr");t.a={timeStamp:function(e){if("string"==typeof e){var t=e.split(" ");if(1===t.length){var a=t[0].match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);return null===a?(new Date).getTime():new Date(a[1],a[3]-1,a[4]).getTime()}var r=t[0].match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/),d=t[1].match(/^(\d{1,2})(-|\:)(\d{1,2})\2(\d{1,2})$/);return r&&d?new Date(r[1],r[3]-1,r[4],d[1],d[3],d[4]).getTime():(new Date).getTime()}return"number"==typeof e?864e5*e:(new Date).getTime()},formatDate:function(e,t){var a=e?new Date(e):new Date,r=a.getFullYear(),d=a.getMonth()+1,c=a.getDate(),u=a.getHours(),o=a.getMinutes(),n=a.getSeconds(),i=function(e){return(e=e.toString())[1]?e:"0"+e};return[r,d,c].map(i).join(t||"-")+" "+[u,o,n].map(i).join(":")}}},"W2P+":function(e,t,a){},Witu:function(e,t,a){},YhG6:function(e,t,a){},cSvC:function(e,t,a){"use strict";var r=a("W2P+");a.n(r).a},i6nb:function(e,t,a){"use strict";var r=a("jEHv");a.n(r).a},jEHv:function(e,t,a){},jq09:function(e,t,a){"use strict";a("rGqo"),a("yt8O"),a("RW0V"),a("Z2Ku");var r=a("z0WU"),d=a("LvDl");function c(e){for(var t=1;t<arguments.length;t++){var a=null!=arguments[t]?arguments[t]:{},r=Object.keys(a);"function"==typeof Object.getOwnPropertySymbols&&(r=r.concat(Object.getOwnPropertySymbols(a).filter(function(e){return Object.getOwnPropertyDescriptor(a,e).enumerable}))),r.forEach(function(t){u(e,t,a[t])})}return e}function u(e,t,a){return t in e?Object.defineProperty(e,t,{value:a,enumerable:!0,configurable:!0,writable:!0}):e[t]=a,e}var o={elName:"",animations:[],commonStyle:{position:"absolute",width:300,height:30,top:200,left:0,rotate:0,paddingTop:0,paddingLeft:0,paddingRight:0,paddingBottom:0,marginTop:0,marginLeft:0,marginRight:0,marginBottom:0,borderWidth:0,borderColor:"",borderStyle:"solid",borderRadius:0,boxShadow:"",fontSize:16,fontWeight:500,lineHeight:1.4,letterSpacing:0,textAlign:"center",color:"#000000",backgroundColor:"",backgroundImage:"",backgroundSize:"cover",opacity:1,zIndex:1},events:[],propsValue:{},value:"",valueType:"String"},n={name:"",elements:[],commonStyle:{backgroundColor:"",backgroundImage:"",backgroundSize:"cover"},config:{}},i={name:"",title:"未命名场景",description:"我用夸克可视化编辑器做了一个超酷炫的H5，快来看看吧。",coverImage:"",auther:"",script:"",width:300,height:300,pages:[]},s=function(e){var t=arguments.length>1&&void 0!==arguments[1]?arguments[1]:{};return(e=Object(d.cloneDeep)(e)).uuid=Object(r.f)(),e.commonStyle=Object(d.merge)(e.commonStyle,t),e.commonStyle.top=e.commonStyle.top+10,e.commonStyle.left=e.commonStyle.left+10,e},p=function(){return c({uuid:Object(r.f)()},Object(d.cloneDeep)(n))};t.a={elementConfig:o,pageConfig:n,projectConfig:i,getElementConfig:function(e){var t=arguments.length>1&&void 0!==arguments[1]?arguments[1]:{},a=Object(d.cloneDeep)(e),u=a.valueType||"String",n=Object(d.cloneDeep)(o),i=c({uuid:Object(r.f)()},n,{elName:a.elName,propsValue:Object(r.h)(a.needProps||{})});return i.commonStyle=Object(d.merge)(i.commonStyle,a.defaultStyle),i.commonStyle=Object(d.merge)(i.commonStyle,t),i.value=e.defaultValue||{Sting:"",Array:[],Object:{},Boolean:!1,Number:0}[u],i.valueType=u,i.isForm=!!e.isForm,i},getPageConfig:p,getProjectConfig:function(){var e=Object(d.cloneDeep)(i),t=p();return e.pages.push(c({},t)),c({},e)},copyPage:function(e){var t=Object(d.cloneDeep)(e);return t.uuid=Object(r.f)(),t.elements=t.elements.map(function(e){return s(e)}),t},copyElement:s,getCommonStyle:function(e,t,a,d){var c=["width","left"],u=["height","top"],o=["fontSize"],n=Object(r.h)(e),i={};for(var s in n)c.includes(s)?i[s]="".concat(n[s]/t*100,"%"):u.includes(s)?i[s]="".concat(n[s]/a*100,"%"):o.includes(s)?i[s]="".concat(n[s]*((d||t)/t),"px"):i[s]=n[s];return i.transform="rotate(".concat(i.rotate,"deg)"),i.backgroundImage=i.backgroundImage?"url(".concat(i.backgroundImage,")"):"",i}}},o3SY:function(e,t,a){"use strict";var r=a("+Jge");a.n(r).a},oeZg:function(e,t,a){},r6V5:function(e,t,a){"use strict";var r=a("zY7s");a.n(r).a},uVyu:function(e,t,a){"use strict";var r=a("EiiD");a.n(r).a},"y+pX":function(e,t,a){"use strict";var r=a("YhG6");a.n(r).a},z1Gy:function(e,t,a){"use strict";a("rGqo"),a("f3/d");var r={name:"QkImage",props:{imageSrc:{type:String,default:"http://seopic.699pic.com/photo/50051/4111.jpg_wh1200.jpg"},id:{type:String,default:""}},methods:{}},d=(a("B7Ix"),a("KHd+")),c=Object(d.a)(r,function(){var e=this.$createElement,t=this._self._c||e;return t("div",{staticClass:"qk-image"},[t("img",{attrs:{id:this.id,src:this.imageSrc}})])},[],!1,null,"3b18bde8",null);c.options.__file="index.vue";var u=c.exports;u.install=function(e){e.component(u.name,u)};var o=u,n=(a("KKXr"),a("TB3a")),i={name:"QkDate",props:{value:{type:String,default:""},item:{type:Object,default:function(){return null}}},data:function(){return{dateValue:"",dateTimer:""}},created:function(){var e=this;this.dateValue=n.a.formatDate().split(" ")[0];var t=864e5+60*(new Date).getTimezoneOffset()*1e3-((new Date).getTime()-new Date(this.dateValue).getTime());this.dateTimer=setTimeout(function(t){e.dateValue=n.a.formatDate().split(" ")[0]},t)},beforeDestroy:function(){clearTimeout(this.dateTimer)}},s=(a("cSvC"),Object(d.a)(i,function(){var e=this.$createElement;return(this._self._c||e)("div",{staticClass:"qk-date",domProps:{textContent:this._s(this.dateValue)}})},[],!1,null,"0a731891",null));s.options.__file="index.vue";var p=s.exports;p.install=function(e){e.component(p.name,p)};var f=p,l={name:"QkDatetime",props:{value:{type:String,default:""},item:{type:Object,default:function(){return null}}},data:function(){return{dateValue:"",dateTimer:""}},created:function(){var e=this;this.dateValue=n.a.formatDate(),this.dateTimer=setInterval(function(t){e.dateValue=n.a.formatDate()},1e3)},beforeDestroy:function(){clearInterval(this.dateTimer)}},b=(a("y+pX"),Object(d.a)(l,function(){var e=this.$createElement;return(this._self._c||e)("div",{staticClass:"qk-datetime",domProps:{textContent:this._s(this.dateValue)}})},[],!1,null,"8e1adfbc",null));b.options.__file="index.vue";var m=b.exports;m.install=function(e){e.component(m.name,m)};var h=m,g={name:"QkTime",props:{value:{type:String,default:""},item:{type:Object,default:function(){return null}}},data:function(){return{timeValue:"",dateTimer:""}},created:function(){var e=this;this.timeValue=n.a.formatDate().split(" ")[1],this.dateTimer=setInterval(function(t){e.timeValue=n.a.formatDate().split(" ")[1]},1e3)},beforeDestroy:function(){clearInterval(this.dateTimer)}},v=(a("i6nb"),Object(d.a)(g,function(){var e=this.$createElement;return(this._self._c||e)("div",{staticClass:"qk-time",domProps:{textContent:this._s(this.timeValue)}})},[],!1,null,"726f3bfc",null));v.options.__file="index.vue";var I=v.exports;I.install=function(e){e.component(I.name,I)};var w=I,C={name:"QkInput",props:{value:{type:String,default:""},readonly:{type:Boolean,default:!1},item:{type:Object,default:function(){return null}}},data:function(){return{userValue:this.value}},watch:{userValue:function(){this.$emit("value-bus",{value:this.userValue,uuid:this.item.uuid})}}},O=(a("r6V5"),Object(d.a)(C,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"qk-input"},[a("input",{directives:[{name:"model",rawName:"v-model",value:e.userValue,expression:"userValue"}],staticClass:"qk-input-item",attrs:{placeholder:e.readonly?"":"请输入",type:"text",readonly:e.readonly},domProps:{value:e.userValue},on:{input:function(t){t.target.composing||(e.userValue=t.target.value)}}})])},[],!1,null,"32c6f443",null));O.options.__file="index.vue";var y=O.exports;y.install=function(e){e.component(y.name,y)};var N=y,S={name:"QkTextarea",props:{value:{require:!1},readonly:{type:Boolean,default:!1},item:{type:Object,default:function(){return null}}},data:function(){return{tempValue:this.value}},watch:{tempValue:function(){this.$emit("value-bus",{value:this.tempValue,uuid:this.item.uuid})}}},k=(a("o3SY"),Object(d.a)(S,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"qk-textarea"},[a("textarea",{directives:[{name:"model",rawName:"v-model",value:e.tempValue,expression:"tempValue"}],staticClass:"qk-textarea-item",style:{width:e.item.defaultStyle.width+"px",height:e.item.defaultStyle.height+"px"},attrs:{placeholder:e.readonly?"":"请输入",readonly:e.readonly},domProps:{value:e.tempValue},on:{input:function(t){t.target.composing||(e.tempValue=t.target.value)}}})])},[],!1,null,"1400af3b",null));k.options.__file="index.vue";var x=k.exports;x.install=function(e){e.component(x.name,x)};var U=x,G={code:0,msg:"执行成功!",result:{hideTitles:["id","productGenre","productUnit","warehouseId","cuser","uuser","udate","remark","isdisable","qrcode","productSpec","productName","businessId","productUnitName","warehouseOutCode","code","parentId","productId","executeCount","progress"],pageData:{},titles:[{cdate:"创建时间"},{progress:"进度"},{warehouseOutCode:"出库单编码"},{productCode:"货品编码"},{productName:"货品名称"},{productSpec:" 规格/型号"},{productGenreName:"货品属性"},{productUnitName:"计量单位"},{count:"出库数量"},{id:"id"},{productGenre:"货品属性ID"},{productUnit:"计量单位ID"},{parentId:"出库单ID"},{warehouseId:" (推荐)货位ID"},{productId:"产品ID"},{code:"批次号"},{executeCount:"已出库数量"},{cuser:"创建用户id"},{uuser:"修改用户id"},{udate:"修改时间"},{remark:"备注"},{isdisable:"是否启用"},{qrcode:"二维码"},{businessId:"业务id"},{state:"状态"}],varList:[{businessId:"",cdate:"2018-10-30 10:44:18",code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",id:"05c56e2e63804a9f81781a540307fa8f",isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"P000008",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:"原材料",productId:"01de8e2c87074f06b32567d7c1275808",productName:"333",productSpec:"2",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"55",qrcode:"",remark:"122",state:"已完成",udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"O000007"},{businessId:"",cdate:"2018-10-30 10:44:18",code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",id:"05csae2e63804a9f81781a540307fa8f",isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"P000008",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:"原材料",productId:"01de8e2c87074f06b32567d7c1275808",productName:"333",productSpec:"2",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"20",qrcode:"",remark:"122",state:"已完成",udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"O000008"},{businessId:"",cdate:"2018-10-30 10:44:18",code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",id:"05ce5e2e63804a9f81781a540307fa8f",isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"P000008",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:"原材料",productId:"01de8e2c87074f06b32567d7c1275808",productName:"333",productSpec:"2",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"20",qrcode:"",remark:"122",state:"已完成",udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"O000006"},{businessId:"",cdate:"2018-10-30 10:44:18",code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",id:"05cere2e63804a9f81781a540307fa8f",isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"P000008",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:"原材料",productId:"01de8e2c87074f06b32567d7c1275808",productName:"333",productSpec:"2",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"20",qrcode:"",remark:"122",state:"已完成",udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"O000006"},{businessId:"",cdate:"2018-10-30 10:44:18",code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",id:"05cete2e63804a9f81781a540307fa8f",isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"P000008",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:"原材料",productId:"01de8e2c87074f06b32567d7c1275808",productName:"333",productSpec:"2",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"20",qrcode:"",remark:"122",state:"已完成",udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"O000006"},{businessId:"",cdate:"2018-10-30 10:44:18",code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",id:"05ceye2e63804a9f81781a540307fa8f",isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"P000008",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:"原材料",productId:"01de8e2c87074f06b32567d7c1275808",productName:"333",productSpec:"2",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"20",qrcode:"",remark:"122",state:"已完成",udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"O000006"},{businessId:"",cdate:"2018-10-30 10:44:18",code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",id:"05ceue2e63804a9f81781a540307fa8f",isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"P000008",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:"原材料",productId:"01de8e2c87074f06b32567d7c1275808",productName:"333",productSpec:"2",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"20",qrcode:"",remark:"122",state:"已完成",udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"O000006"},{businessId:"",cdate:"2018-10-30 10:44:18",code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",id:"05ceie2e63804a9f81781a540307fa8f",isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"P000008",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:"原材料",productId:"01de8e2c87074f06b32567d7c1275808",productName:"333",productSpec:"2",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"20",qrcode:"",remark:"122",state:"已完成",udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"O000006"},{businessId:"",cdate:"2018-10-30 10:44:18",code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",id:"05ceoe2e63804a9f81781a540307fa8f",isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"P000008",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:"原材料",productId:"01de8e2c87074f06b32567d7c1275808",productName:"333",productSpec:"2",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"20",qrcode:"",remark:"122",state:"已完成",udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"O000006"},{businessId:"",cdate:"2018-10-30 10:44:18",code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",id:"05cepe2e63804a9f81781a540307fa8f",isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"P000008",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:"原材料",productId:"01de8e2c87074f06b32567d7c1275808",productName:"333",productSpec:"2",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"20",qrcode:"",remark:"122",state:"已完成",udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"O000006"},{businessId:"",cdate:"2018-10-30 10:44:18",code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",id:"05ce1e2e63804a9f81781a540307fa8f",isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"P000008",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:"原材料",productId:"01de8e2c87074f06b32567d7c1275808",productName:"333",productSpec:"2",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"20",qrcode:"",remark:"122",state:"已完成",udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"O000006"},{businessId:"",cdate:"2018-10-30 10:44:18",code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",id:"05ceae2e63804a9f81781a540307fa8f",isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"P000008",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:"原材料",productId:"01de8e2c87074f06b32567d7c1275808",productName:"333",productSpec:"2",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"20",qrcode:"",remark:"122",state:"已完成",udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"O000006"},{businessId:"",cdate:"2018-10-30 10:44:18",code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",id:"05ceze2e63804a9f81781a540307fa8f",isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"P000008",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:"原材料",productId:"01de8e2c87074f06b32567d7c1275808",productName:"333",productSpec:"2",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"20",qrcode:"",remark:"122",state:"已完成",udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"O000006"},{businessId:"",cdate:"2018-10-30 10:44:18",code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",id:"05cexe2e63804a9f81781a540307fa8f",isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"P000008",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:"原材料",productId:"01de8e2c87074f06b32567d7c1275808",productName:"333",productSpec:"2",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"20",qrcode:"",remark:"122",state:"已完成",udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"O000006"},{businessId:"",cdate:"2018-10-30 10:44:18",code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",id:"05cece2e63804a9f81781a540307fa8f",isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"P000008",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:"原材料",productId:"01de8e2c87074f06b32567d7c1275808",productName:"333",productSpec:"2",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"20",qrcode:"",remark:"122",state:"已完成",udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"O000006"},{businessId:"",cdate:"2018-10-30 10:44:18",code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",id:"05ceve2e63804a9f81781a540307fa8f",isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"P000008",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:"原材料",productId:"01de8e2c87074f06b32567d7c1275808",productName:"333",productSpec:"2",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"20",qrcode:"",remark:"122",state:"已完成",udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"O000006"},{businessId:"",cdate:"2018-10-30 10:44:18",code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",id:"05cebe2e63804a9f81781a540307fa8f",isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"P000008",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:"原材料",productId:"01de8e2c87074f06b32567d7c1275808",productName:"333",productSpec:"2",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"20",qrcode:"",remark:"122",state:"已完成",udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"O000006"},{businessId:"",cdate:"2018-10-30 10:44:18",code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",id:"05cene2e63804a9f81781a540307fa8f",isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"P000008",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:"原材料",productId:"01de8e2c87074f06b32567d7c1275808",productName:"333",productSpec:"2",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"20",qrcode:"",remark:"122",state:"已完成",udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"O000006"},{businessId:"",cdate:"2018-10-30 10:44:18",code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",id:"05ceme2e63804a9f81781a540307fa8f",isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"P000008",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:"原材料",productId:"01de8e2c87074f06b32567d7c1275808",productName:"333",productSpec:"2",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"20",qrcode:"",remark:"122",state:"已完成",udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"O000006"},{businessId:"",cdate:"2018-10-30 10:44:18",code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",id:"05cele2e63804a9f81781a540307fa8f",isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"P000008",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:"原材料",productId:"01de8e2c87074f06b32567d7c1275808",productName:"333",productSpec:"2",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"20",qrcode:"",remark:"122",state:"已完成",udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"O000006"},{businessId:"",cdate:"2018-10-30 10:44:18",code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",id:"05ceke2e63804a9f81781a540307fa8f",isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"P000008",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:"原材料",productId:"01de8e2c87074f06b32567d7c1275808",productName:"333",productSpec:"2",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"20",qrcode:"",remark:"122",state:"已完成",udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"O000006"},{businessId:"",cdate:"2018-10-30 10:44:18",code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",id:"05ceje2e63804a9f81781a540307fa8f",isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"P000008",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:"原材料",productId:"01de8e2c87074f06b32567d7c1275808",productName:"333",productSpec:"2",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"20",qrcode:"",remark:"122",state:"已完成",udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"O000006"},{businessId:"",cdate:"2018-10-30 10:44:18",code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",id:"05cehe2e63804a9f81781a540307fa8f",isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"P000008",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:"原材料",productId:"01de8e2c87074f06b32567d7c1275808",productName:"333",productSpec:"2",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"20",qrcode:"",remark:"122",state:"已完成",udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"O000006"},{businessId:"",cdate:"2018-10-30 10:44:18",code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",id:"05cege2e63804a9f81781a540307fa8f",isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"P000008",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:"原材料",productId:"01de8e2c87074f06b32567d7c1275808",productName:"333",productSpec:"2",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"20",qrcode:"",remark:"122",state:"已完成",udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"O000006"},{businessId:"",cdate:"2018-10-30 10:44:18",code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",id:"05cefe2e63804a9f81781a540307fa8f",isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"P000008",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:"原材料",productId:"01de8e2c87074f06b32567d7c1275808",productName:"333",productSpec:"2",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"20",qrcode:"",remark:"122",state:"已完成",udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"O000006"},{businessId:"",cdate:"2018-10-30 10:44:18",code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",id:"05cede2e63804a9f81781a540307fa8f",isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"P000008",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:"原材料",productId:"01de8e2c87074f06b32567d7c1275808",productName:"333",productSpec:"2",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"20",qrcode:"",remark:"122",state:"已完成",udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"O000006"},{businessId:"",cdate:"2018-10-30 10:44:18",code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",id:"05ce9e2e63804a9f81781a540307fa8f",isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"P000008",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:"原材料",productId:"01de8e2c87074f06b32567d7c1275808",productName:"333",productSpec:"2",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"20",qrcode:"",remark:"122",state:"已完成",udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"O000006"},{businessId:"",cdate:"2018-10-30 10:44:18",code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",id:"05ce8e2e63804a9f81781a540307fa8f",isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"P000008",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:"原材料",productId:"01de8e2c87074f06b32567d7c1275808",productName:"333",productSpec:"2",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"20",qrcode:"",remark:"122",state:"已完成",udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"O000006"},{businessId:"",cdate:"2018-10-30 10:44:18",code:"",count:"10.00",cuser:"bf3b8b63be1b4f1f96984b33ccd77784",executeCount:"10.00",id:"05ce7e2e63804a9f81781a540307fa8f",isdisable:"1",parentId:"08e06e2e63804a9f81781a540307fa8f",pid:null,productCode:"P000008",productGenre:"7e2cad38438e40ba974cd00099e5ed71",productGenreName:"原材料",productId:"01de8e2c87074f06b32567d7c1275808",productName:"333",productSpec:"2",productUnit:"3ab6399760da48049bc76705fa797217",productUnitName:"克",progress:"20",qrcode:"",remark:"122",state:"已完成",udate:"2018-11-08 17:30:33",uuser:"",warehouseId:"",warehouseOutCode:"O000006"}]}},D={name:"warehouse-task-list",props:{baseHeader:{type:Array,default:function(){return[]}},tableList:{type:Array,default:function(){return[]}}},data:function(){return{tableListViewsWidth:[180,80,70,70,60],reseted:!1,viewWidth:0}},computed:{setTableList:function(){return this.tableList.map(function(e){return e})},hasData:function(){return!!this.baseHeader.length},taskTableLoading:function(){return this.hasData&&this.reseted}},methods:{},created:function(){},mounted:function(){var e=this;this.viewWidth=this.$parent.$el.clientWidth,setTimeout(function(t){e.reseted=!0},5e3)}},P=(a("PM9h"),Object(d.a)(D,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{directives:[{name:"loading",rawName:"v-loading",value:!e.taskTableLoading,expression:"!taskTableLoading"}],staticClass:"warehouse-task-list"},[e.baseHeader.length?[a("div",{staticClass:"baseHeader"},e._l(e.baseHeader,function(t,r){return a("div",{key:r,staticClass:"baseHeaderViews",style:{width:e.tableListViewsWidth[r]+"px"}},[e._v(e._s(t.label))])}))]:e._e(),e._v(" "),e.setTableList.length?[a("ul",e._l(e.setTableList,function(t){return a("li",{key:t.id,staticClass:"tableList"},e._l(e.baseHeader,function(r,d){return a("div",{key:d,staticClass:"tableListViews",style:{width:e.tableListViewsWidth[d]+"px"}},[e._v(e._s(t[r.prop]))])}))}))]:[a("div",{staticStyle:{height:"100%","text-align":"center","font-size":"24px","font-weight":"500","padding-top":"20%",color:"inherit"}},[e._v("暂无数据")])]],2)},[],!1,null,null,null));P.options.__file="warehouseTaskList.vue";var j=P.exports,_=a("z0WU"),q={name:"QkTable",components:{warehouseTaskList:j},props:{value:{type:String,default:""},readonly:{type:Boolean,default:!1},item:{type:Object,default:function(){return null}}},data:function(){return{tableData:null,baseHeader:[],tableList:[]}},computed:{componentName:function(){return"warehouseTaskList"},showIndex:function(){return!(!this.tableData||!this.item.config)&&this.item.config.showIndex},colConfigs:function(){return this.tableData?this.tableData.titleList:[]},dataList:function(){return this.tableData?this.tableData.tableData:[]},setApiObj:function(){return{apiName:"listPageWarehouseOutDetailsDispatch",params:{pageNo:1,queryStr:"detail.id in ('219967d2f6704d868b11002caef9885c')"}}}},watch:{},methods:{indexMethod:function(e){return e+1},rowClassName:function(e,t){console.log(e,t)},httpRequest:function(){var e=this;setTimeout(function(t){e.baseHeader=Object(_.n)(G.result),e.tableList=G.result.varList.slice()},1e3)}},created:function(){console.log(this.item),this.httpRequest()}},T=(a("1H0o"),Object(d.a)(q,function(){var e=this.$createElement,t=this._self._c||e;return t("div",{staticClass:"qk-table"},[t(this.componentName,{tag:"component",staticClass:"qk-table-item",attrs:{baseHeader:this.baseHeader,tableList:this.tableList}})],1)},[],!1,null,null,null));T.options.__file="index.vue";var V=T.exports;V.install=function(e){e.component(V.name,V)};var L=V;a.d(t,"a",function(){return H});var E=[o,f,h,w,N,U,L],$=function e(t){e.installed||(e.installed=!0,E.map(function(e){return t.component(e.name,e)}))};"undefined"!=typeof window&&window.Vue&&$(window.Vue);var H={};E.forEach(function(e){H[e.name]=e})},zY7s:function(e,t,a){}}]);