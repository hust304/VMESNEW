(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-7b55"],{"/uea":function(t,e,i){},"0ZVU":function(t,e,i){"use strict";i.r(e);i("a1Th"),i("rGqo");var s=i("Yfch"),n=(i("TB3a"),{name:"warehouse-task-list",props:{customData:{type:Object,default:function(){return null}},readonly:{type:Boolean,default:!0}},data:function(){return{reseted:!1,viewWidth:0,ulHeight:0,boxHeight:0,baseItemTime:2,tableList:[],resizeTimer:null,initTimer:null}},computed:{setApiObj:function(){return this.customData&&this.customData.config?this.customData.config.apiObj:null},setBaseHeader:function(){return this.customData&&this.customData.config?this.customData.config.headers:[]},titleFontSize:function(){return this.customData&&this.customData.config?this.customData.config.titleFontSize:16},bodyFontSize:function(){return this.customData&&this.customData.config?this.customData.config.bodyFontSize:14},tableListViewsWidth:function(){var t=0;return this.customData.config.columnScale.forEach(function(e){t+=e}),this.customData.config.columnScale.map(function(e){return e/t})},setTableList:function(){return this.tableList.map(function(t){return t})},hasData:function(){return!!this.setBaseHeader.length},taskTableLoading:function(){return this.hasData&&this.reseted},setTableListViewsWidth:function(){var t=this;return this.tableListViewsWidth.map(function(e){return Math.floor(e*((t.viewWidth||500)-t.setTitleFontSize/3*2))})},setTitleFontSize:function(){return this.viewWidth?this.viewWidth/500*this.titleFontSize:this.titleFontSize},setBodyFontSize:function(){return this.viewWidth?this.viewWidth/500*this.bodyFontSize:this.bodyFontSize},maxTitleString:function(){var t=this;return this.setTableListViewsWidth.map(function(e){return Math.floor(e/t.setTitleFontSize)})},maxBodyString:function(){var t=this;return this.setTableListViewsWidth.map(function(e){return Math.floor(e/t.setBodyFontSize)})},scrollBarWidth:function(){return this.ulHeight&&this.boxHeight&&this.ulHeight+3*this.setTitleFontSize>this.boxHeight?17:0},setBaseItemTime:function(){return this.baseItemTime},setListViewAn:function(){if(this.scrollBarWidth&&this.taskTableLoading){var t=this.$el.querySelector(".tableList").clientHeight,e=Math.floor(this.ulHeight/t);return{animation:"listViewScroll ".concat((this.setTableList.length+e)*this.setBaseItemTime,"s linear infinite normal")}}return{}}},methods:{setBodyStrStyle:function(t,e){if(!e)return"50%";var i=e+"",n=1;return Object(s.b)(i)&&(n=1.5),Math.floor(this.maxBodyString[t]*n)>=i.length?"50%":"0"},setBodyStrContent:function(t,e){if(!e)return"middle";var i=e+"",n=1;return Object(s.b)(i)&&(n=1.5),Math.floor(this.maxBodyString[t]*n)>=i.length?"middle":"start"},httpRequest:function(){var t=this;this.setApiObj&&this.$api[this.setApiObj.apiName](this.setApiObj.params).then(function(e){t.tableList=(e.result||[]).map(function(e){return e.cdate&&(e.cdate=t.formatDate(e.cdate)),e})}).catch(function(t){})},formatDate:function(t,e){var i=t?new Date(t):new Date,s=i.getFullYear(),n=i.getMonth()+1,o=i.getDate(),a=i.getHours(),r=i.getMinutes(),l=function(t){return(t=t.toString())[1]?t:"0"+t};return[s,n,o].map(l).join(e||"-")+" "+[a,r].map(l).join(":")},scrollFunc:function(t){return(t=t||window.event).preventDefault?(t.preventDefault(),t.stopPropagation()):(t.cancelBubble=!0,t.returnValue=!1),!1},myResizeFn:function(){var t=this;clearTimeout(this.resizeTimer),this.resizeTimer=setTimeout(function(e){t.viewWidth=t.$parent.$el.clientWidth,t.boxHeight=t.$refs.getBoxHeight.offsetHeight,t.ulHeight=t.$refs.getUlHeight.offsetHeight-t.ulHeight},16.67)}},watch:{setTableList:function(){var t=this;this.setTableList.length&&this.$nextTick(function(e){var i=t.$refs.getUlHeight.offsetHeight;t.boxHeight=t.$refs.getBoxHeight.offsetHeight,t.ulHeight=t.ulHeight?i-t.ulHeight:i})}},created:function(){this.httpRequest()},mounted:function(){var t=this;this.initTimer=setTimeout(function(e){t.viewWidth=t.$parent.$el.clientWidth,t.reseted=!0,!t.readonly&&addResizeListener(t.$el,t.myResizeFn)})},beforeDestroy:function(){clearTimeout(this.initTimer),this.readonly||this.$el.__resizeTrigger__.contentDocument&&removeResizeListener(this.$el,this.myResizeFn)}}),o=(i("PM9h"),i("KHd+")),a=Object(o.a)(n,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"warehouse-task-list"},[i("div",{staticStyle:{height:"100%",overflow:"hidden"}},[t.setBaseHeader.length?[i("div",{staticClass:"baseHeaderBox"},[i("div",{staticClass:"baseHeader"},t._l(t.setBaseHeader,function(e,s){return i("div",{key:s,staticClass:"baseHeaderViews",style:{width:t.setTableListViewsWidth[s]+"px",height:2.5*t.setTitleFontSize+"px",paddingTop:t.setTitleFontSize/4+"px"}},[i("div",{staticStyle:{position:"relative",height:"100%"}},[i("svg",{attrs:{width:.9*t.setTableListViewsWidth[s],height:2*t.setTitleFontSize,viewBox:"0 0 "+.9*t.setTableListViewsWidth[s]+" "+2*t.setTitleFontSize}},[i("text",{attrs:{"font-size":t.setTitleFontSize,x:"50%",y:"50%",fill:"#ffffff","text-anchor":"middle","dominant-baseline":"middle"}},[t._v(t._s(e.label))])])])])}))])]:t._e(),t._v(" "),t.setTableList.length?[i("div",{ref:"getBoxHeight",staticStyle:{height:"100%","z-index":"1"},style:{paddingTop:3*t.setTitleFontSize+"px",width:"calc(100% + "+t.scrollBarWidth+"px)",overflow:t.scrollBarWidth?"auto":"hidden"},on:{mousewheel:function(e){t.scrollFunc(e)}}},[i("ul",{ref:"getUlHeight",style:t.setListViewAn},[t._l(t.setTableList,function(e){return i("li",{key:e.id,staticClass:"tableList",style:{padding:t.setTitleFontSize/3+"px"}},t._l(t.setBaseHeader,function(s,n){return i("div",{key:n,staticClass:"tableListViews",style:{width:t.setTableListViewsWidth[n]+"px",height:2*t.setBodyFontSize+"px"}},[i("div",{staticStyle:{position:"relative",height:"100%"}},["状态"!=s.label?i("div",{staticStyle:{height:"100%"}},[i("svg",{attrs:{width:.9*t.setTableListViewsWidth[n],height:2*t.setBodyFontSize,viewBox:"0 0 "+.9*t.setTableListViewsWidth[n]+" "+2*t.setBodyFontSize}},[i("text",{attrs:{"font-size":.9*t.setBodyFontSize,x:t.setBodyStrStyle(n,e[s.prop]),y:"50%",fill:"#ffffff","text-anchor":t.setBodyStrContent(n,e[s.prop]),"dominant-baseline":"middle"}},[t._v(t._s(e[s.prop]))])])]):i("div",{staticStyle:{height:"100%"}},[i("svg",{attrs:{width:.85*t.setTableListViewsWidth[n],height:2*t.setBodyFontSize,viewBox:"0 0 "+.85*t.setTableListViewsWidth[n]+" "+2*t.setBodyFontSize}},[i("rect",{style:{fill:"已完成"===e[s.prop]?"rgb(0,176,80)":"rgb(255,255,0)"},attrs:{width:"100%",height:"100%"}}),t._v(" "),i("text",{attrs:{"font-size":.9*t.setBodyFontSize,x:"50%",y:"50%",fill:"已完成"===e[s.prop]?"#fff":"#000","text-anchor":"middle","dominant-baseline":"middle"}},[t._v(t._s(e[s.prop]))])])])])])}))}),t._v(" "),t.scrollBarWidth?i("li",{style:{height:this.ulHeight+"px"}}):t._e()],2)])]:[i("div",{staticStyle:{height:"100%","text-align":"center","font-weight":"500","padding-top":"20%",color:"#ffffff"},style:{fontSize:2*t.bodyFontSize+"px"}},[t._v("暂无数据")])]],2)])},[],!1,null,null,null);a.options.__file="warehouseTaskList.vue";e.default=a.exports},PM9h:function(t,e,i){"use strict";var s=i("/uea");i.n(s).a}}]);