(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-79f2","FgPX"],{"7Zgp":function(e,t,o){e.exports=o.p+"static/img/ouhaiglasses.6c773bd.png"},FgPX:function(e,t,o){"use strict";o.r(t);o("rGqo"),o("yt8O"),o("RW0V"),o("Yfch");var a=o("L2JU"),i=o("XS0u");function n(e,t,o){return t in e?Object.defineProperty(e,t,{value:o,enumerable:!0,configurable:!0,writable:!0}):e[t]=o,e}t.default={data:function(){var e=this;return{loginForm:{username:"",password:"",authcode:""},loginRules:{username:[{required:!0,trigger:"blur",validator:function(e,t,o){t.trim()?o():o(new Error("请输入正确的用户名"))}}],password:[{required:!0,trigger:"blur",validator:function(e,t,o){t.length<0?o(new Error("密码不能小于5位")):o()}}],authcode:[{required:!0,trigger:"blur",validator:function(t,o,a){var i=o.toUpperCase();i&&e.authcode?i!==e.authcode?a(new Error("验证码错误")):a():a(new Error("验证码不匹配"))}}]},loading:!1,pwdType:"password",checked:!1,lading:null,codeTimer:""}},created:function(){var e=i.a.localGet("auth")||{};e.password&&(this.loginForm.username=e.username,this.loginForm.password=e.password,this.checked=!0),this.$loading(),this.changeCode(),this.$loading({}).close()},mounted:function(){},methods:{showPwd:function(){"password"===this.pwdType?this.pwdType="":this.pwdType="password"},handleLogin:function(){var e=this,t=this;t.savePwd(t.checked),t.$refs.loginForm.validate(function(o){if(!o)return console.log("error submit!!"),!1;t.loading=!0,t.$store.dispatch("Login",e.loginForm).then(function(e){clearTimeout(t.codeTimer),t.loading=!1,t.$store.dispatch("tagsView/delAllViews").then(function(e){e.visitedViews}),t.$router.push({path:"/home"})}).catch(function(){t.loading=!1,t.$loading({}).close()})})},savePwd:function(e){if(e){var t={username:this.loginForm.username,password:this.loginForm.password};console.log(t),i.a.localSet("auth",t)}else i.a.localRemove("auth")},changeCode:function(){var e=this;e.$store.dispatch("CreateSecurityCode",{}).then(function(){e.$refs.loginForm&&e.$refs.loginForm.clearValidate&&e.$refs.loginForm.clearValidate(),e.loginForm.authcode="",e.drawPic(e.authcode),clearTimeout(e.codeTimer),e.codeTimer=setTimeout(function(t){e.changeCode()},27e3)}).catch(function(){e.$refs.loginForm&&e.$refs.loginForm.clearValidate&&e.$refs.loginForm.clearValidate(),clearTimeout(e.codeTimer),e.codeTimer=setTimeout(function(t){e.changeCode()},27e3)})},drawPic:function(e){var t=document.getElementById("canvas"),o=t.width,a=t.height,i=t.getContext("2d");function n(e,t){return Math.floor(Math.random()*(t-e)+e)}function r(e,t){return"rgb("+n(e,t)+","+n(e,t)+","+n(e,t)+")"}i.textBaseline="bottom",i.fillStyle=r(180,240),i.fillRect(0,0,o,a);for(var s=e,l=0;l<4;l++){var c=s[l];i.fillStyle=r(50,160),i.font=n(18,30)+"px SimHei";var d=5+20*l,u=n(25,30),h=n(-30,30);i.translate(d,u),i.rotate(h*Math.PI/180),i.fillText(c,0,0),i.rotate(-h*Math.PI/180),i.translate(-d,-u)}}},computed:function(e){for(var t=1;t<arguments.length;t++){var o=null!=arguments[t]?arguments[t]:{},a=Object.keys(o);"function"==typeof Object.getOwnPropertySymbols&&(a=a.concat(Object.getOwnPropertySymbols(o).filter(function(e){return Object.getOwnPropertyDescriptor(o,e).enumerable}))),a.forEach(function(t){n(e,t,o[t])})}return e}({},Object(a.b)(["authcode"]),{btnState:function(){return!(this.loginForm.username&&this.loginForm.password&&this.loginForm.authcode)}}),watch:{checked:function(){this.checked||i.a.localRemove("auth")}}}},S3Uu:function(e,t,o){"use strict";var a=o("giWo");o.n(a).a},giWo:function(e,t,o){},hIy0:function(e,t,o){},l7u9:function(e,t,o){"use strict";var a=o("hIy0");o.n(a).a},pLN4:function(e,t,o){"use strict";o.r(t);var a=[function(){var e=this.$createElement,t=this._self._c||e;return t("div",{staticClass:"clearfix",staticStyle:{float:"left",width:"50%",height:"100%",position:"relative"}},[t("div",{staticStyle:{position:"absolute",top:"50%",left:"50%",transform:"translate(-50%,-50%)",width:"70%",height:"auto"}},[t("img",{staticStyle:{width:"100%",height:"auto"},attrs:{src:o("7Zgp")}})])])}],i={name:"login",mixins:[o("FgPX").default]},n=(o("l7u9"),o("S3Uu"),o("KHd+")),r=Object(n.a)(i,function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",{staticClass:"login-container"},[e._m(0),e._v(" "),o("div",{staticClass:"clearfix",staticStyle:{float:"left",width:"50%",height:"100%",position:"relative","background-color":"rgb(191,191,191)"}},[o("div",{staticStyle:{position:"absolute",top:"50%",left:"50%",transform:"translate(-50%,-50%)",width:"100%",height:"655px"}},[o("div",{staticStyle:{height:"100%",position:"relative"}},[o("p",{staticStyle:{"text-align":"center","font-size":"5vh","font-weight":"600","letter-spacing":"5px"}},[e._v("瓯海区眼镜企业")]),e._v(" "),o("p",{staticStyle:{"text-align":"center","font-size":"5vh","font-weight":"600","letter-spacing":"5px"}},[e._v("运营管理系统")]),e._v(" "),o("el-form",{ref:"loginForm",staticClass:"login-form",attrs:{autoComplete:"on",model:e.loginForm,rules:e.loginRules,"label-position":"left","status-icon":""}},[o("el-form-item",{attrs:{prop:"username"}},[o("span",{staticClass:"svg-container svg-container_login"},[o("svg-icon",{attrs:{"icon-class":"user"}})],1),e._v(" "),o("el-input",{attrs:{name:"username",type:"text",clearable:"",autoComplete:"on",placeholder:"请输入用户名"},model:{value:e.loginForm.username,callback:function(t){e.$set(e.loginForm,"username",t)},expression:"loginForm.username"}})],1),e._v(" "),o("el-form-item",{attrs:{prop:"password"}},[o("span",{staticClass:"svg-container"},[o("svg-icon",{attrs:{"icon-class":"password"}})],1),e._v(" "),o("el-input",{attrs:{name:"password",type:e.pwdType,clearable:"",autoComplete:"on",placeholder:"请输入密码"},model:{value:e.loginForm.password,callback:function(t){e.$set(e.loginForm,"password",t)},expression:"loginForm.password"}}),e._v(" "),o("span",{staticClass:"show-pwd",attrs:{title:e.$t("base.showPwd")},on:{click:e.showPwd}},[o("svg-icon",{directives:[{name:"show",rawName:"v-show",value:e.pwdType,expression:"pwdType"}],attrs:{"icon-class":"eye"}}),o("svg-icon",{directives:[{name:"show",rawName:"v-show",value:!e.pwdType,expression:"!pwdType"}],attrs:{"icon-class":"eye_open"}})],1)],1),e._v(" "),o("el-form-item",{staticClass:"loginCss",attrs:{prop:"authcode"}},[o("el-input",{staticStyle:{width:"60%",border:"2px solid rgba(217, 217, 217, 1)","border-radius":"5px"},attrs:{type:"text",clearable:"",name:"authcode",placeholder:"请输入右侧验证码"},nativeOn:{keyup:function(t){return"button"in t||!e._k(t.keyCode,"enter",13,t.key,"Enter")?e.handleLogin(t):null}},model:{value:e.loginForm.authcode,callback:function(t){e.$set(e.loginForm,"authcode",t)},expression:"loginForm.authcode"}}),e._v(" "),o("div",{attrs:{id:"authcodeBox"}},[o("div",{attrs:{id:"canvasBox"}},[o("canvas",{directives:[{name:"show",rawName:"v-show",value:e.authcode,expression:"authcode"}],attrs:{id:"canvas",width:"83",height:"32",title:"点击更换验证码"},on:{click:e.changeCode}}),e._v(" "),o("div",{directives:[{name:"show",rawName:"v-show",value:!e.authcode,expression:"!authcode"}],staticStyle:{height:"100%","text-align":"center","background-color":"#e0e0e0",cursor:"pointer"},on:{click:e.changeCode}},[e._v("获取验证码")])])])],1),e._v(" "),o("el-form-item",{staticClass:"loginCss"},[o("el-button",{staticStyle:{width:"100%"},attrs:{type:"primary",loading:e.loading,disabled:e.btnState},nativeOn:{click:function(t){return t.preventDefault(),e.handleLogin(t)}}},[e._v("\n                登 录\n              ")])],1),e._v(" "),o("div",{staticClass:"tips"},[o("el-checkbox",{staticStyle:{color:"#fff"},model:{value:e.checked,callback:function(t){e.checked=t},expression:"checked"}},[e._v("记住密码")])],1)],1)],1)])])])},a,!1,null,"04fbcb03",null);r.options.__file="index.vue";t.default=r.exports}}]);