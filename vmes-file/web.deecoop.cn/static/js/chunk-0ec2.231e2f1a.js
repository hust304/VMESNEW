(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-0ec2"],{I2uc:function(t,e,i){},Rfob:function(t,e,i){"use strict";i.r(e);i("f3/d");var a=i("uTIz"),n=i("z0WU"),s=i("gepB"),o={data:function(){return{loading:!0,viewWidth:0,dialogVisible:!1,searchList:[{label:"看板名称",type:"input",ruleType:"string",mapKey:"kanbanName",configs:{},placeholder:"请输入名称"}],guid:"",searchName:"",kanbanList:[],userSelectLayout:null}},components:{searchBar:a.a,visualizationTemplate:s.a},created:function(){this.httpRequest()},mounted:function(){this.viewWidth=this.$el.clientWidth},methods:{sendGuid:function(t){this.guid=t},searchMap:function(t){this.searchName=t.kanbanName||""},httpRequest:function(){var t=this;this.loading=!0,this.$api.userKanbanList().then(function(e){t.kanbanList=(e.result||[]).map(function(t){var e=JSON.parse(t.layout);return e.id=t.id,e}),t.loading=!1}).catch(function(e){t.loading=!1})},createName:function(t,e,i){return t&&"default"!==t?t:(i.name="看板".concat(Object(n.r)(e+1)),i.name)},removeLayout:function(t,e){var i=this;this.loading=!0,this.$api.deleteUserKanban({id:t.id}).then(function(t){i.httpRequest()}).catch(function(t){})},previewLayout:function(t){this.userSelectLayout=t,this.dialogVisible=!0},editLayout:function(t){t.name="test2",this.httpSaveEditLayout({id:t.id,title:t.name,layout:JSON.stringify(t)})},httpSaveEditLayout:function(t){var e=this;this.loading=!0,this.$api.updateUserKanban(t).then(function(t){e.httpRequest()}).catch(function(t){e.loading=!1})},closeview:function(){this.dialogVisible=!1,this.userSelectLayout=null},createLayout:function(){this.$router.push({path:"/kanban/customKanban"})},setImgUrl:function(t){return"https://web.deecoop.cn/"+t}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0)+"px":"100%"},setKanbanList:function(){var t=this;return this.kanbanList.filter(function(e){return!t.searchName||(!e.name||"default"===e.name||e.name.indexOf(t.searchName)>-1)})},setSpan:function(){return this.viewWidth?24/(Math.ceil(this.viewWidth/800)+1):6}},watch:{}},l=(i("qSl3"),i("KHd+")),c=Object(l.a)(o,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.loading,expression:"loading"}],staticClass:"kanbanList"},[t.searchList.length?i("search-bar",{attrs:{searchList:t.searchList},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),i("el-row",{staticStyle:{"border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s",overflow:"auto"},style:{height:t.tableHeight,"margin-top":t.searchList.length?"10px":"0"}},[t.kanbanList.length?t._l(t.setKanbanList,function(e,a){return i("el-col",{key:a,staticStyle:{padding:"1vh"},attrs:{span:t.setSpan}},[i("el-card",{attrs:{"body-style":{padding:"0px"},shadow:"hover"}},[i("div",{staticStyle:{padding:"1.5vh","text-align":"center"},domProps:{textContent:t._s(t.createName(e.name,a,e))}}),t._v(" "),i("div",{staticStyle:{height:"22vh","text-align":"center"}},[i("img",{staticClass:"image",attrs:{src:t.setImgUrl(e.baseImg)}})]),t._v(" "),i("div",{staticStyle:{padding:"1.5vh"}},[i("div",{staticClass:"bottom clearfix"},[i("el-button",{staticClass:"button",staticStyle:{float:"left"},attrs:{type:"text"},on:{click:function(i){t.removeLayout(e,a)}}},[t._v("删除")]),t._v(" "),i("el-button",{staticClass:"button",staticStyle:{float:"right"},attrs:{type:"text"},on:{click:function(i){t.previewLayout(e)}}},[t._v("展示")]),t._v(" "),i("el-button",{staticClass:"button",staticStyle:{"margin-right":"20px",float:"right"},attrs:{type:"text"},on:{click:function(i){t.editLayout(e)}}},[t._v("编辑")])],1)])])],1)}):t._e(),t._v(" "),t.kanbanList.length||t.loading?t._e():[i("div",{staticStyle:{"padding-top":"15vh","text-align":"center","font-size":"26px"}},[i("div",{staticStyle:{display:"inline-block"}},[i("div",[t._v("没有看板，前往定制？")]),t._v(" "),i("div",{staticStyle:{"margin-top":"1vh"}},[i("el-button",{staticStyle:{"font-size":"26px"},attrs:{type:"text"},on:{click:t.createLayout}},[t._v("定制看板")])],1)])])]],2),t._v(" "),i("el-dialog",{attrs:{visible:t.dialogVisible,fullscreen:""},on:{"update:visible":function(e){t.dialogVisible=e}}},[t.dialogVisible?i("visualizationTemplate",{tag:"component",attrs:{visualizationConfig:t.userSelectLayout},on:{closeview:t.closeview}}):t._e()],1)],1)},[],!1,null,null,null);c.options.__file="index.vue";e.default=c.exports},qSl3:function(t,e,i){"use strict";var a=i("I2uc");i.n(a).a}}]);