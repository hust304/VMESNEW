(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-4124"],{He6P:function(e,t,o){"use strict";var n=o("OtWr");o.n(n).a},OtWr:function(e,t,o){},c11S:function(e,t,o){"use strict";var n=o("gTgX");o.n(n).a},gTgX:function(e,t,o){},ntYl:function(e,t,o){"use strict";o.r(t);o("rGqo"),o("yt8O"),o("RW0V"),o("Yfch");var n=o("L2JU"),a=o("XS0u");function r(e,t,o){return t in e?Object.defineProperty(e,t,{value:o,enumerable:!0,configurable:!0,writable:!0}):e[t]=o,e}var i={name:"login",data:function(){var e=this;return{loginForm:{username:"",password:"",authcode:""},loginRules:{username:[{required:!0,trigger:"blur",validator:function(e,t,o){t.trim()?o():o(new Error("请输入正确的用户名"))}}],password:[{required:!0,trigger:"blur",validator:function(e,t,o){t.length<0?o(new Error("密码不能小于5位")):o()}}],authcode:[{required:!0,trigger:"blur",validator:function(t,o,n){var a=o.toUpperCase();a&&e.authcode?a!==e.authcode?n(new Error("验证码错误")):n():n(new Error("验证码不匹配"))}}]},loading:!1,pwdType:"password",checked:!1,lading:null,codeTimer:""}},created:function(){var e=a.a.localGet("auth")||{};console.log(e),e.password&&(this.loginForm.username=e.username,this.loginForm.password=e.password,this.checked=!0),this.$loading(),this.changeCode(),this.$loading({}).close()},mounted:function(){},methods:{showPwd:function(){"password"===this.pwdType?this.pwdType="":this.pwdType="password"},handleLogin:function(){var e=this,t=this;t.savePwd(t.checked),t.$refs.loginForm.validate(function(o){if(!o)return console.log("error submit!!"),!1;t.loading=!0,t.$store.dispatch("Login",e.loginForm).then(function(e){clearTimeout(t.codeTimer),t.loading=!1,t.$router.push({path:"/home"})}).catch(function(){t.loading=!1,t.$loading({}).close()})})},savePwd:function(e){if(e){var t={username:this.loginForm.username,password:this.loginForm.password};console.log(t),a.a.localSet("auth",t)}else a.a.localRemove("auth")},changeCode:function(){var e=this;e.$store.dispatch("CreateSecurityCode",{}).then(function(){e.$refs.loginForm&&e.$refs.loginForm.clearValidate&&e.$refs.loginForm.clearValidate(),e.loginForm.authcode="",e.drawPic(e.authcode),clearTimeout(e.codeTimer),e.codeTimer=setTimeout(function(t){e.changeCode()},27e3)}).catch(function(){e.$refs.loginForm&&e.$refs.loginForm.clearValidate&&e.$refs.loginForm.clearValidate(),clearTimeout(e.codeTimer),e.codeTimer=setTimeout(function(t){e.changeCode()},27e3)})},drawPic:function(e){var t=document.getElementById("canvas"),o=t.width,n=t.height,a=t.getContext("2d");function r(e,t){return Math.floor(Math.random()*(t-e)+e)}function i(e,t){return"rgb("+r(e,t)+","+r(e,t)+","+r(e,t)+")"}a.textBaseline="bottom",a.fillStyle=i(180,240),a.fillRect(0,0,o,n);for(var s=e,c=0;c<4;c++){var l=s[c];a.fillStyle=i(50,160),a.font=r(18,30)+"px SimHei";var d=5+20*c,u=r(25,30),h=r(-30,30);a.translate(d,u),a.rotate(h*Math.PI/180),a.fillText(l,0,0),a.rotate(-h*Math.PI/180),a.translate(-d,-u)}}},computed:function(e){for(var t=1;t<arguments.length;t++){var o=null!=arguments[t]?arguments[t]:{},n=Object.keys(o);"function"==typeof Object.getOwnPropertySymbols&&(n=n.concat(Object.getOwnPropertySymbols(o).filter(function(e){return Object.getOwnPropertyDescriptor(o,e).enumerable}))),n.forEach(function(t){r(e,t,o[t])})}return e}({},Object(n.b)(["authcode"]),{btnState:function(){return!(this.loginForm.username&&this.loginForm.password&&this.loginForm.authcode)}}),watch:{checked:function(){this.checked||a.a.localRemove("auth")}}},s=(o("c11S"),o("He6P"),o("KHd+")),c=Object(s.a)(i,function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",{staticClass:"login-container"},[o("el-form",{ref:"loginForm",staticClass:"login-form",attrs:{autoComplete:"on",model:e.loginForm,rules:e.loginRules,"label-position":"left","status-icon":""}},[o("h3",{staticClass:"title"},[e._v("智造云管家")]),e._v(" "),o("el-form-item",{attrs:{prop:"username"}},[o("span",{staticClass:"svg-container svg-container_login"},[o("svg-icon",{attrs:{"icon-class":"user"}})],1),e._v(" "),o("el-input",{attrs:{name:"username",type:"text",clearable:"",autoComplete:"on",placeholder:"请输入用户名"},model:{value:e.loginForm.username,callback:function(t){e.$set(e.loginForm,"username",t)},expression:"loginForm.username"}})],1),e._v(" "),o("el-form-item",{attrs:{prop:"password"}},[o("span",{staticClass:"svg-container"},[o("svg-icon",{attrs:{"icon-class":"password"}})],1),e._v(" "),o("el-input",{attrs:{name:"password",type:e.pwdType,clearable:"",autoComplete:"on",placeholder:"请输入密码"},model:{value:e.loginForm.password,callback:function(t){e.$set(e.loginForm,"password",t)},expression:"loginForm.password"}}),e._v(" "),o("span",{staticClass:"show-pwd",attrs:{title:e.$t("base.showPwd")},on:{click:e.showPwd}},[o("svg-icon",{directives:[{name:"show",rawName:"v-show",value:e.pwdType,expression:"pwdType"}],attrs:{"icon-class":"eye"}}),o("svg-icon",{directives:[{name:"show",rawName:"v-show",value:!e.pwdType,expression:"!pwdType"}],attrs:{"icon-class":"eye_open"}})],1)],1),e._v(" "),o("el-form-item",{staticClass:"loginCss",attrs:{prop:"authcode"}},[o("el-input",{staticStyle:{width:"60%",border:"1px solid rgba(0, 0, 0, 0.3)"},attrs:{type:"text",clearable:"",name:"authcode",placeholder:"请输入右侧验证码"},nativeOn:{keyup:function(t){return"button"in t||!e._k(t.keyCode,"enter",13,t.key,"Enter")?e.handleLogin(t):null}},model:{value:e.loginForm.authcode,callback:function(t){e.$set(e.loginForm,"authcode",t)},expression:"loginForm.authcode"}}),e._v(" "),o("div",{attrs:{id:"authcodeBox"}},[o("div",{attrs:{id:"canvasBox"}},[o("canvas",{directives:[{name:"show",rawName:"v-show",value:e.authcode,expression:"authcode"}],attrs:{id:"canvas",width:"83",height:"32",title:"点击更换验证码"},on:{click:e.changeCode}}),e._v(" "),o("div",{directives:[{name:"show",rawName:"v-show",value:!e.authcode,expression:"!authcode"}],staticStyle:{height:"100%","text-align":"center","background-color":"#e0e0e0",cursor:"pointer"},on:{click:e.changeCode}},[e._v("获取验证码")])])])],1),e._v(" "),o("el-form-item",{staticClass:"loginCss"},[o("el-button",{staticStyle:{width:"100%"},attrs:{type:"primary",loading:e.loading,disabled:e.btnState},nativeOn:{click:function(t){return t.preventDefault(),e.handleLogin(t)}}},[e._v("\n\t\t\t\t\t登 录\n\t\t\t\t")])],1),e._v(" "),o("div",{staticClass:"tips"},[o("el-checkbox",{model:{value:e.checked,callback:function(t){e.checked=t},expression:"checked"}},[e._v("记住密码")])],1)],1)],1)},[],!1,null,"29e71d2c",null);c.options.__file="index.vue";t.default=c.exports}}]);