(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-4d8c"],{"9CiS":function(t,e,i){},ozwT:function(t,e,i){"use strict";i.r(e);i("rGqo"),i("yt8O"),i("RW0V");var n=i("e+jF"),o=i("MngD"),a=i("jq09"),u=i("z1Gy");function r(t,e,i){return e in t?Object.defineProperty(t,e,{value:i,enumerable:!0,configurable:!0,writable:!0}):t[e]=i,t}var l={name:"visualization-preview",components:function(t){for(var e=1;e<arguments.length;e++){var i=null!=arguments[e]?arguments[e]:{},n=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(n=n.concat(Object.getOwnPropertySymbols(i).filter(function(t){return Object.getOwnPropertyDescriptor(i,t).enumerable}))),n.forEach(function(e){r(t,e,i[e])})}return t}({GridLayout:n.GridLayout,GridItem:n.GridItem,editShape:o.a},u.a),data:function(){return{layoutBoxHeight:0,visualizationConfig:null,getCommonStyle:a.b.getCommonStyle}},computed:{tempLayout:function(){return this.visualizationConfig?this.visualizationConfig.layout:[]},setRowHeight:function(){return this.layoutBoxHeight/24}},methods:{goHome:function(){this.$router.push({path:"/"})}},mounted:function(){var t=this;this.layoutBoxHeight=this.$el.clientHeight,this.$nextTick(function(e){t.visualizationConfig=t.$storage.get("visualizationConfig")})}},s=(i("qnkF"),i("KHd+")),c=Object(s.a)(l,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"visualizationPreview"},[t.visualizationConfig?i("div",{staticClass:"visualizationPreviewView"},[i("grid-layout",{attrs:{layout:t.tempLayout,"col-num":24,"row-height":t.setRowHeight,"max-rows":24,"vertical-compact":!0,margin:[0,0],"use-css-transforms":!0},on:{"update:layout":function(e){t.tempLayout=e}}},t._l(t.tempLayout,function(e){return i("grid-item",{key:e.i,staticStyle:{"background-color":"rgb(10,24,40)"},attrs:{x:e.x,y:e.y,w:e.w,h:e.h,i:e.i,"is-resizable":!1,"is-draggable":!1}},[i("div",{staticStyle:{position:"relative",height:"100%"}},t._l(e.userComponents||[],function(e){return i("edit-shape",{key:e.uuid,style:t.getCommonStyle(e.defaultStyle),attrs:{uuid:e.uuid,defaultStyle:e.defaultStyle,active:!1,data:e}},[i(e.elName,t._b({tag:"component",staticClass:"element-on-edit-pane",attrs:{id:e.uuid}},"component",{value:e.value,item:e},!1))],1)}),1)])}),1)],1):i("div",{staticStyle:{height:"100%","text-align":"center","padding-top":"200px","font-size":"30px"}},[i("div",[t._v("没有可用的配置")]),t._v(" "),i("div",[i("el-button",{on:{click:t.goHome}},[t._v("返回首页")])],1)])])},[],!1,null,"11c8f24b",null);c.options.__file="visualizationPreview.vue";e.default=c.exports},qnkF:function(t,e,i){"use strict";var n=i("9CiS");i.n(n).a}}]);