(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-6c94","chunk-f804","chunk-365e"],{"/PT8":function(t,e,i){"use strict";var a=i("uqOe");i.n(a).a},F9dT:function(t,e,i){"use strict";i.d(e,"a",function(){return c}),i.d(e,"c",function(){return d}),i.d(e,"b",function(){return u});i("pIFo"),i("SRfc"),i("KKXr"),i("INYr"),i("rGqo");var a=i("Yfch"),n=i("TB3a"),o=i("YP4+"),s=i("z0WU"),l=function(){return function(t,e,i){var n,o,s;e?(o=e-0,n=!0,s=t.ops[t.ops.length-1],t.ops&&t.ops.length&&t.ops.forEach(function(e,i){i<t.ops.length-1&&(s?Object(a.b)(e-0)?(!Object(a.b)(o)||e-0>o)&&(n=!1):e-0>o&&(n=!1):Object(a.b)(e-0)?(!Object(a.b)(o)||e-0>=o)&&(n=!1):e-0>=o&&(n=!1))}),n?i():i(new Error(t.message))):i(new Error("不能为空"))}},r=function(){return function(t,e,i){var n,o,s;e?(o=e-0,n=!0,s=t.ops[t.ops.length-1],t.ops&&t.ops.length&&t.ops.forEach(function(e,i){i<t.ops.length-1&&(s?Object(a.b)(e-0)?(!Object(a.b)(o-0)||o>e-0)&&(n=!1):o>e-0&&(n=!1):Object(a.b)(e-0)?(!Object(a.b)(o-0)||o>=e-0)&&(n=!1):o>=e-0&&(n=!1))}),n?i():i(new Error(t.message))):i(new Error("不能为空"))}};function c(t,e,i,a,n,o,s,c,u,p,g){var h,f,b,m,v;return t&&(h=d(t.greaterThan,n,o,u,!0,p)),m=c.findIndex(function(t){return t.greaterThan}),e&&(f=d(e.lessThan,n,o,u,!1,p)),v=c.findIndex(function(t){return t.lessThan}),b=[],h&&b.push({validator:l(),trigger:"blur",message:s[g||m],ops:h}),f&&b.push({validator:r(),trigger:"blur",message:s[g||v],ops:f}),b}function d(t,e,i,a,n,o,s){var l;"boolean"==typeof(t=JSON.parse(JSON.stringify(t)))[t.length-1]&&(l=t.pop());var r=t.map(function(t){return""});return t.forEach(function(t,l){var c=t.split(/\([\\+|\-|\\*|\\/]\)/);if(c.length>1)r.splice(l,1,u(c,e,i,a,t,o,s));else if(-1!==t.indexOf("@")){var d=t.split("@");2===d.length&&"self"===d[0]&&r.splice(l,1,e[d[1]]),2===d.length&&"parent"===d[0]&&r.splice(l,1,i[0][d[1]]),2===d.length&&"tempData"===d[0]&&r.splice(l,1,o[d[1]]),2===d.length&&"sibling"===d[0]&&r.splice(l,1,p(d[1],a,e,!1,n)),3===d.length&&"parent"===d[0]&&r.splice(l,1,JSON.parse(JSON.stringify(i)).reverse()[d[1]-1][d[2]])}else r.splice(l,1,t)}),"boolean"==typeof l?r.push(l):r.push(!0),r}function u(t,e,i,l,r,c,d){var u=t.map(function(t){return""});t.forEach(function(t,a){var n=t.split("@"),o=0;if(2===n.length)switch(n[0]){case"self":o=e[n[1]];break;case"parent":o=i[i.length-1][n[1]];break;case"tempData":o=c[n[1]];break;case"sibling":o=p(n[1],l,e,!0)}else 3===n.length?o=JSON.parse(JSON.stringify(i)).reverse()[n[1]-1][n[2]]:1===n.length&&(o=n[0]-0);u.splice(a,1,o||0)});var g=r.match(/\([\\+|\-|\\*|\\/]\)/g).map(function(t){return t.replace(/\(|\)/g,"")}),h="",f=function(t){if(Object(a.b)(t))return"number";if("string"==typeof t&&/^[0-9]{4}\-[0-9]{2}\-[0-9]{2}/.test(t))return"date"}(u[0]);return"number"===f?(u.forEach(function(t,e){g[e]?h+=t+g[e]:h+=t}),parseFloat(Object(s.i)(h).toFixed(d||o.a.precision))):"date"===f?(u.forEach(function(t,e){var i=n.a.timeStamp(t);g[e]?h+=i+g[e]:h+=i}),n.a.formatDate(Object(s.i)(h))):0}function p(t,e,i,a,n){var o=[],s=0,l=e.findIndex(function(t){return t.id===i.id});return e.forEach(function(e,i){l!==i&&o.push(e[t])}),a?o.forEach(function(t){s+=t-0}):s=n?Math.min.apply(Math,o):Math.max.apply(Math,o),s}},TB3a:function(t,e,i){"use strict";i("a1Th"),i("SRfc"),i("KKXr");e.a={timeStamp:function(t){if("string"==typeof t){var e=t.split(" ");if(1===e.length){var i=e[0].match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);return null===i?(new Date).getTime():new Date(i[1],i[3]-1,i[4]).getTime()}var a=e[0].match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/),n=e[1].match(/^(\d{1,2})(-|\:)(\d{1,2})\2(\d{1,2})$/);return a&&n?new Date(a[1],a[3]-1,a[4],n[1],n[3],n[4]).getTime():(new Date).getTime()}return"number"==typeof t?864e5*t:(new Date).getTime()},formatDate:function(t,e){var i=t?new Date(t):new Date,a=i.getFullYear(),n=i.getMonth()+1,o=i.getDate(),s=i.getHours(),l=i.getMinutes(),r=i.getSeconds(),c=function(t){return(t=t.toString())[1]?t:"0"+t};return[a,n,o].map(c).join(e||"-")+" "+[s,l,r].map(c).join(":")}}},"Wc/n":function(t,e,i){},YfbJ:function(t,e,i){"use strict";var a=i("zcV0");i.n(a).a},lNSx:function(t,e,i){"use strict";i("rE2o"),i("ioFf"),i("Oyvg"),i("pIFo"),i("f3/d");var a=i("yO6P"),n=i("Yfch");function o(t){return(o="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var s={},l=function(t){a.a.hasOwnProperty(t)&&(s[t]=function(e){return[{validator:(i=t,s=a.a[i]||"",function(t,e,i){var a,l,r;t.ops&&"object"===o(t.ops)?(t.ops.len?a=l=t.ops.len-0:(a=Object(n.b)(t.ops.min)?t.ops.min:0,l=Object(n.b)(t.ops.max)?t.ops.max:0),r=l>=a?a+","+(l||""):"0,",s=t.ops.customReg&&"string"==typeof t.ops.customReg?t.ops.customReg:s.replace(/placeholder/g,r)):s=s.replace(/placeholder/g,"0,"),e?new RegExp(s,"g").test(e)?i():i(" "):i()}),trigger:"change",ops:e}];var i,s})};for(var r in a.a)l(r);e.a=s},oC0i:function(t,e,i){"use strict";i.r(e);i("rE2o"),i("ioFf"),i("rGqo"),i("f3/d");var a=i("ukxx"),n=i.n(a),o=i("Do8I"),s=i("zF5t"),l=i("z0WU");function r(t){return(r="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var c={components:{},name:"dialog-add",props:["initData","visible"],data:function(){return{roleId:"",rules:{},temp:{},tempLable:{},tempNotEditable:{},dialogLoading:!1,isVisible:!1,inDialog:!0,openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{fullscreen:!1,title:"",data:null},assignTree:[],assignTreeConfigs:{showSearch:!0},assignCheckedList:[],assignFilterText:"",dialogAssignChecked:!1,clickArrow:!1,defaultProps:{children:"children",label:"url"},treeConfigs:{ref:"tree",showCheckBox:!1,showIcons:!1},transferData:[],transferSelectedData:[],renderFunc:function(t,e){return t("span",{style:"display: inline-block;width: 100%;"},[" ",t("span",{style:"display: inline-block;width: 20%;text-align: center;"},[" ",e.index]),t("span",{style:"display: inline-block;width: 39%;text-align: center;"},[e.userCode])," ",t("span",{style:"display: inline-block;width: 39%;text-align: center;"},[" ",e.userName])])},transferProps:{key:"id",label:"userName",code:"userCode",disabled:"isdisable",index:"index"},resState:null}},created:function(){this.initData.temp&&(this.temp=this.initData.temp),this.roleId=this.temp.roleId,this.treeDepartments();var t=this.$storage.get("userInfo").companyId;this.assignTreeDataBridge({id:t})},mounted:function(){this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=r(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){this.$nextTick(function(){if(!document.getElementsByClassName("customTitle").length)for(var t=document.getElementsByClassName("el-transfer-panel__filter"),e=0;e<t.length;e++){var i=(new(n.a.extend({template:'<div class="customTitle" style="box-sizing: border-box;padding: 5px 0 5px 41px;height: 25px;box-shadow:0 3px 5px -3px rgba(0,0,0,0.3);">\n                        <span style="display: inline-block;width: 100%;">\n                        <span style="display: inline-block;width: 20%;text-align: center;">序号</span>\n                        <span style="display: inline-block;width: 37%;text-align: center;">账号</span>\n                        <span style="display: inline-block;width: 38%;text-align: center;">姓名</span>\n                        </span>\n                      </div>'}))).$mount(),a=t[e],o=a.parentNode,s=a.nextSibling;s?o.insertBefore(i.$el,s):o.appendChild(i.$el)}})},dialogClose:function(t){this.$emit("close-dialog",t||{})},assignFilterNode:function(t,e){return!t||-1!==e.name.indexOf(t)},treeDepartments:function(){var t=this;this.dialogLoading=!0,Object(o.treeDepartments)({isdisable:"1"}).then(function(e){t.assignTree=[e.result.treeList],t.$nextTick(function(e){t.$refs.assignTree.setCurrentKey(t.assignTree[0].id)})}).catch(function(e){t.dialogLoading=!1})},assignFilterKey:function(t){var e=[];return t.forEach(function(t){e.push(t.id)}),e},assignTreeDataBridge:function(t){var e=this;this.transferData=[],this.transferSelectedData=[];var i={deptId:t.id,roleId:this.roleId},a={roleId:this.roleId};this.$axios.all([Object(s.listUsersByRole)(a),Object(s.listAllUsersByDeptId)(i)]).then(this.$axios.spread(function(t,i){var a=Object(l.s)(t.result.varList.concat(i.result.varList));a.forEach(function(t,e){t.index=e+1}),e.transferData=a,e.transferSelectedData=e.assignFilterKey(t.result.varList),e.$loading().close(),e.dialogLoading=!1})).catch(function(t){e.$loading().close(),e.dialogLoading=!1})},handleChange:function(t,e,i){},saveUsersByRole:function(){var t=this;Object(s.saveRoleUsers)({roleId:this.roleId,userIds:Object(l.k)(this.transferSelectedData)}).then(function(e){0===e.code&&(t.$notify({title:"成功",message:"保存成功",type:"success",duration:1e3}),t.isVisible=!1,t.dialogClose({resState:"ok"})),t.$loading().close()}).catch(function(e){t.$loading().close()})},closeDialog:function(t){this.showDialog=!1}}},d=(i("uoYy"),i("KHd+")),u=Object(d.a)(c,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"850px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}],staticClass:"dialogRoleUserStyle",staticStyle:{height:"500px"}},[i("el-col",{staticStyle:{position:"relative",height:"100%",overflow:"hidden"},attrs:{span:6}},[i("div",{staticStyle:{position:"absolute",top:"-10px",bottom:"-10px",left:"0",right:"5px","background-color":"#EBF0F6","box-shadow":"5px 0 10px -5px rgba(0,0,0,0.3)","box-sizing":"border-box",padding:"10px 0"}},[i("div",{staticClass:"leftTree",staticStyle:{height:"100%","padding-top":"10px"}},[i("el-input",{attrs:{placeholder:"",clearable:""},model:{value:t.assignFilterText,callback:function(e){t.assignFilterText=e},expression:"assignFilterText"}},[i("i",{staticClass:"el-input__icon el-icon-search",attrs:{slot:"suffix"},slot:"suffix"})]),t._v(" "),i("div",{staticClass:"treeView",staticStyle:{height:"calc(100% - 85px)",overflow:"auto"}},[i("el-tree",{ref:"assignTree",attrs:{"highlight-current":"","default-expand-all":"","node-key":"id","expand-on-click-node":t.clickArrow,data:t.assignTree,props:t.defaultProps,"filter-node-method":t.assignFilterNode},on:{"node-click":t.assignTreeDataBridge},scopedSlots:t._u([{key:"default",fn:function(e){var a=e.node,n=e.data;return i("span",{staticClass:"custom-tree-node"},[t.treeConfigs.showIcons?i("svg-icon",{staticStyle:{"margin-right":"5px"},attrs:{"icon-class":n.url}}):t._e(),t._v(" "),a.label?i("span",[t._v(t._s(a.label))]):i("span",[t._v(t._s(n.name))])],1)}}])})],1)],1)])]),t._v(" "),i("el-col",{staticStyle:{height:"100%"},attrs:{span:18}},[i("div",{staticStyle:{height:"calc(100% - 60px)","box-sizing":"border-box",padding:"7px 0"}},[i("div",{staticStyle:{"text-align":"center"}},[i("el-transfer",{staticStyle:{"text-align":"left",display:"inline-block"},attrs:{filterable:"",props:t.transferProps,"left-default-checked":[],"right-default-checked":[],"render-content":t.renderFunc,titles:["未分配用户","已分配用户"],format:{noChecked:"${total}",hasChecked:"${checked}/${total}"},data:t.transferData},on:{change:t.handleChange},model:{value:t.transferSelectedData,callback:function(e){t.transferSelectedData=e},expression:"transferSelectedData"}})],1)]),t._v(" "),i("div",{staticStyle:{position:"relative",height:"60px","text-align":"center","box-sizing":"border-box",padding:"10px 0 0 0"}},[i("el-button",{attrs:{type:"primary"},on:{click:t.saveUsersByRole}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)])],1)],1)},[],!1,null,null,null);u.options.__file="dialogRoleUser.vue";e.default=u.exports},uoYy:function(t,e,i){"use strict";var a=i("Wc/n");i.n(a).a},uqOe:function(t,e,i){},vleD:function(t,e,i){"use strict";i.r(e);i("yt8O"),i("RW0V"),i("rGqo");var a=i("mSNy"),n=i("t3Un"),o=i("z0WU");function s(t,e,i){return e in t?Object.defineProperty(t,e,{value:i,enumerable:!0,configurable:!0,writable:!0}):t[e]=i,t}var l={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n\t\t\t\t\t\t<div slot-scope="scope">\n    \t\t\t\t\t\t<el-switch active-value="1" inactive-value="0" v-model="scope.row.isdisable" @change="colConfig.changeState(scope.row,scope.$index)"></el-switch>\n    \t\t\t\t\t</div>\n    \t\t\t   </el-table-column>'},r={name:"dialog-option",props:["initData","visible"],data:function(){return{dialogTopLoading:!1,isVisible:!1,title:"",userInfo:null,topBarBtnList:[{name:"查询",icon:"search",method:this.queryTable},{name:"重置",icon:"refresh",plain:!0,method:this.resetQueryTemp}],configs:{tableConfigs:[],showCheckBox:!1,showIndex:!1,isSingle:!1},tableData:[],selectList:[],queryParms:[{name:"code"},{name:"name"}],tempQuery:{},tempLable:{},pageData:null,pageNo:1}},components:{},beforeCreate:function(){},created:function(){this.title=this.initData.title,this.configs.isSingle=this.initData.isSingle,this.userInfo=this.$storage.get("userInfo"),this.initTable()},beforeMount:function(){},mounted:function(){this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{dialogClose:function(){this.$emit("close-dialog",this.selectList,this.initData.temp)},queryTable:function(){this.pageNo=1,this.initTable()},initTable:function(){var t=this;t.dialogTopLoading=!0,Object(n.a)({url:t.initData.tableUrl,method:"post",data:function(t){for(var e=1;e<arguments.length;e++){var i=null!=arguments[e]?arguments[e]:{},a=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(a=a.concat(Object.getOwnPropertySymbols(i).filter(function(t){return Object.getOwnPropertyDescriptor(i,t).enumerable}))),a.forEach(function(e){s(t,e,i[e])})}return t}({},t.initData.tableParm,t.tempQuery,{pageNo:t.pageNo})}).then(function(e){t.dialogTopLoading=!1,t.getListPage(e)}).catch(function(e){console.log(e),t.dialogTopLoading=!1})},getListPage:function(t){if(t){this.pageData=t.result.pageData,this.initTempData(t.result.titles);var e=Object(o.l)(t.result),i=this.addTableTitle(e);this.configs.tableConfigs=i,this.configs.showCheckBox=!0,this.configs.showIndex=!0,this.tableData=t.result.varList}},initTempData:function(t){var e=this;t.forEach(function(t){for(var i in t){var n=t[i];n.indexOf("_")>0&&("en"==a.a.locale?n=n.substring(n.indexOf("_")+1):"zh"==a.a.locale&&(n=n.substring(0,n.indexOf("_")))),e.tempLable[i]=n}})},addTableTitle:function(t){var e=this;return t.forEach(function(t){var i=t.label;i.indexOf("_")>0&&("en"==a.a.locale?t.label=i.substring(i.indexOf("_")+1):"zh"==a.a.locale&&(t.label=i.substring(0,i.indexOf("_")))),"是否启用"===t.label&&(t.component=l,t.changeState=e.changeState)}),t},dataBridge:function(t){this.selectList=t},resetQueryTemp:function(){for(var t in this.tempQuery)this.tempQuery[t]="";this.pageNo=1,this.initTable()}},computed:{},watch:{pageNo:function(){this.initTable()}}},c=(i("/PT8"),i("KHd+")),d=Object(c.a)(r,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.title,visible:t.isVisible,"append-to-body":"",width:"900px"},on:{"update:visible":function(e){t.isVisible=e},close:t.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogTopLoading,expression:"dialogTopLoading"}]},[i("div",{staticStyle:{height:"50px","box-sizing":"border-box",padding:"7px 20px 7px 7px"}},[i("el-form",{staticClass:"form-inline",staticStyle:{width:"900px",margin:"10px auto"},attrs:{inline:!0,model:t.tempQuery,"label-width":"80px"}},[i("el-col",{staticStyle:{"max-width":"260px"},attrs:{span:6}}),t._v(" "),i("el-col",{staticStyle:{"max-width":"260px"},attrs:{span:6}},[i("el-form-item",{attrs:{label:t.tempLable.code}},[i("el-input",{attrs:{placeholder:t.tempLable.code},model:{value:t.tempQuery.code,callback:function(e){t.$set(t.tempQuery,"code",e)},expression:"tempQuery.code"}})],1)],1),t._v(" "),i("el-col",{staticStyle:{"max-width":"260px"},attrs:{span:6}},[i("el-form-item",{attrs:{label:t.tempLable.name}},[i("el-input",{attrs:{placeholder:t.tempLable.name},model:{value:t.tempQuery.name,callback:function(e){t.$set(t.tempQuery,"name",e)},expression:"tempQuery.name"}})],1)],1),t._v(" "),i("el-col",{staticStyle:{"max-width":"90px"},attrs:{span:3}},[i("el-form-item",[i("base-button",{attrs:{name:t.topBarBtnList[0].name,icon:t.topBarBtnList[0].icon,plain:t.topBarBtnList[0].plain,state:t.topBarBtnList[0].state},on:{myclick:t.topBarBtnList[0].method}})],1)],1),t._v(" "),i("el-col",{staticStyle:{"max-width":"95px"},attrs:{span:3}},[i("el-form-item",[i("base-button",{attrs:{name:t.topBarBtnList[1].name,icon:t.topBarBtnList[1].icon,plain:t.topBarBtnList[1].plain,state:t.topBarBtnList[1].state},on:{myclick:t.topBarBtnList[1].method}})],1)],1)],1)],1),t._v(" "),i("div",{staticStyle:{"box-sizing":"border-box",padding:"7px"}},[i("base-table",{attrs:{data:t.tableData,colConfigs:t.configs.tableConfigs,showCheckBox:t.configs.showCheckBox,showIndex:t.configs.showIndex,isSingle:t.configs.isSingle,pageData:t.pageData,currentpage:t.pageNo},on:{databridge:t.dataBridge,"update:currentpage":function(e){t.pageNo=e}}})],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{position:"relative",height:"60px","text-align":"center","box-sizing":"border-box",padding:"10px 0 0 0"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary",disabled:!t.selectList.length},on:{click:function(e){t.isVisible=!1}}},[t._v("确认")]),t._v(" "),i("el-button",{staticStyle:{"margin-left":"30px"},on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)])])},[],!1,null,null,null);d.options.__file="dialogOption.vue";e.default=d.exports},vrrb:function(t,e,i){"use strict";i.r(e);i("rE2o"),i("ioFf"),i("rGqo");var a=i("7cmB"),n=i("vleD"),o=i("oC0i"),s=i("zF5t"),l=i("PuDp");i("z0WU");function r(t){return(r="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var c={props:["colConfig"],template:'<el-table-column :label="colConfig.label" align="center">\n    \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n    \t\t\t\t\t\t\t<el-button  type="text" class="btns" style="font-size: 12px;" :disabled="scope.row.isdisable===\'0\'" @click="colConfig.change(scope.row,scope.$index)">选择库位</el-button>\n    \t\t\t\t\t</div>\n  \t\t\t\t</el-table-column>'},d={components:{treeFormTable:a.a,dialogOption:n.default,dialogRoleUser:o.default},name:"dialog-add",props:["initData","visible"],data:function(){return{rootData:{},tableSets:{1:{showCheckBox:!1,showIndex:!0,expandOne:!1},2:{showCheckBox:!1,showIndex:!1,isExpands:!1,isSortable:!1,isSingle:!1}},currentpage:1,customColumn:{0:[{columnIndex:"last",prop:"operate",label:"操作",component:c,change:this.change}]},editable:{suggestCount:{type:"input"}},apiObj:{apiName:"listPageWarehouseOutDetailsDispatch",params:{}},addedData:{},userData:[],executorIds:[],isSingle:!0,openDialogName:"",showDialog:!1,inLinVisible:!1,dialogData:{title:"选择员工",data:null,temp:{},tempLable:null,isSingle:!0,tableParm:{}},dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},roleId:"",roleName:""}},created:function(){this.roleId=this.initData.temp.roleId,this.roleName=this.initData.temp.roleName,this.initUserData();var t="",e=this.initData.temp;null!=e&&e.length>0&&e.forEach(function(e){null!=e.id&&e.id.trim().length>0&&(t=0==t.length?"'"+e.id.trim()+"'":t+",'"+e.id.trim()+"'")});var i="";null!=t&&t.trim().length>0&&(i="detail.id in ("+t+")"),this.apiObj.params={queryStr:i,pageNo:1}},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=r(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{databridge:function(t){console.log(t)},addChild:function(t,e){this.dialogCallBackData=t,this.showDialog=!0,this.dialogVisible=!0},addChildRow:function(){this.dialogVisible=!1,this.showDialog=!1,this.addedData={rowData:this.testData,parentData:this.dialogCallBackData}},sendChildrenRow:function(t){},change:function(t,e){this.dialogData.temp=t,this.dialogData.tempLable=this.tempLable,this.dialogData.title="选择库位",this.dialogData.isSingle=!1,this.dialogData.tableUrl="/warehouse/warehouseProduct/listPageWarehouseProductsDispatchOption";var i="";null!=t.parentWarehouseId&&t.parentWarehouseId.trim().length>0&&(i="'%"+t.parentWarehouseId+"%'"),this.dialogData.tableParm={productId:t.productId,isNeedWarehouse:"true",parentWarehouseId:i},this.openDialogName="dialogOption",this.showDialog=!0,this.inLinVisible=!0},initUserData:function(){var t=this;Object(s.findListUserByRole)({userIsdisable:"1",queryStr:"role.id = '"+this.roleId+"'"}).then(function(e){t.userData=[];var i=e.result.options;null!=i&&i.length>0&&i.forEach(function(e){var i=e.id,a=e.userName;null!=i&&i.trim().length>0&&null!=a&&a.trim().length>0&&t.userData.push({key:i,label:a,disabled:!1})})}).catch(function(t){})},dataBridge:function(t){},dialogOpen:function(){},dialogClose:function(t){this.$emit("close-dialog",t||{})},leftCheckChange:function(t){this.isSingle&&this.singleUserData(t)},singleUserData:function(t){var e=this.userData;if(null!=e&&0!=e.length)if(0==t.length)e.forEach(function(t){t.disabled=!1});else if(t.length>0){var i="";t.forEach(function(t){i=i+t+","}),e.forEach(function(t){var e=t.key;-1==i.indexOf(e)&&(t.disabled=!0)})}},addAdmin:function(){var t=this.roleId,e=this.roleName;this.dialogData.temp.roleId=t,this.dialogData.title=e+"-分配用户",this.openDialogName="dialogRoleUser",this.showDialog=!0,this.inLinVisible=!0},save:function(){this.$refs.treeFormTable.getData()},formData:function(t){this.realSave(t)},realSave:function(t){var e=this,i=this.roleId,a=this.roleName;if(null!=i&&0!=i){if(null==this.userData||0==this.userData.length)return this.dialogData.temp.roleId=i,this.dialogData.title=a+"-分配用户",this.openDialogName="dialogRoleUser",this.showDialog=!0,void(this.inLinVisible=!0);if(null!=this.executorIds&&0!=this.executorIds.length)if(this.isSingle&&this.executorIds.length>1)this.$message({type:"warning",duration:5e3,showClose:!0,message:"请选择一位执行人，执行人只允许单选！"});else if(null!=t.tableData&&0!=t.tableData.length){var n="";this.executorIds.forEach(function(t){n=n?n+","+t:t});var o="";if(null==t.tableData||0==t.tableData.length?o+="系统无推荐库位，请通过(选择库位)手动设置库位！":null!=t.tableData&&t.tableData.length>0&&t.tableData.forEach(function(t){var e=t.productCode,i=t.children;null!=i&&0!=i.length||(o=o+"货品编码("+e+") 系统无推荐库位，请通过(选择库位)手动设置库位！")}),null!=o&&o.trim().length>0)this.$message({type:"warning",duration:5e3,showClose:!0,message:o});else{var s=JSON.stringify(t.tableData);Object(l.dispatchWarehouseOutDetail)({jsonDataStr:s,executorIdsStr:n}).then(function(t){0===t.code&&(e.$notify({title:"成功",message:"操作成功",type:"success",duration:2e3}),e.isVisible=!1,e.dialogClose({resState:"ok"}))}).catch(function(t){})}}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请选择出库明细信息！"});else this.$message({type:"warning",duration:5e3,showClose:!0,message:"请选择执行人！"})}else this.$message({type:"warning",duration:5e3,showClose:!0,message:"仓库管理员角色ID为空或空字符串！"})},closeDialog:function(t,e){console.log(t),this.addedData={rowData:t[0],parentData:e},this.initUserData(),this.showDialog=!1}},watch:{pageNo:function(){this.initTable()}}},u=(i("YfbJ"),i("KHd+")),p=Object(u.a)(d,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:t.initData.title?t.initData.title:"",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"1200px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}],staticStyle:{"padding-top":"10px"}},[i("el-row",{staticStyle:{width:"96%","margin-left":"2%",border:"1px solid #E4E4E4","border-bottom":"none",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"}},[i("tree-form-table",{ref:"treeFormTable",attrs:{"expand-all":!0,initData:t.rootData,configs:t.tableSets,currentpage:t.currentpage,customColumn:t.customColumn,editable:t.editable,apiObj:t.apiObj,addedData:t.addedData},on:{"update:currentpage":function(e){t.currentpage=e},"get-data":t.formData,"send-children-row":t.sendChildrenRow,databridge:t.databridge}})],1),t._v(" "),i("el-row",{staticClass:"resetTransferStyle",staticStyle:{"text-align":"center",height:"270px","margin-top":"10px"}},[i("el-transfer",{staticStyle:{height:"100%","text-align":"left",display:"inline-block"},attrs:{data:t.userData,titles:["仓库管理员","执行人"]},on:{"left-check-change":t.leftCheckChange},model:{value:t.executorIds,callback:function(e){t.executorIds=e},expression:"executorIds"}},[i("span",{staticStyle:{"font-size":"12px",color:"#1482f0",cursor:"pointer"},attrs:{slot:"left-footer"},on:{click:t.addAdmin},slot:"left-footer"},[t._v("+添加仓库管理员")])])],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,null,null);p.options.__file="dialogDispatch.vue";e.default=p.exports},zcV0:function(t,e,i){}}]);