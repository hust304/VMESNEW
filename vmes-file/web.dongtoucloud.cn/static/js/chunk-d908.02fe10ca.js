(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-d908"],{"6aE2":function(e,t,i){},Z1wF:function(e,t,i){"use strict";var a=i("6aE2");i.n(a).a},lNSx:function(e,t,i){"use strict";i("rE2o"),i("ioFf"),i("Oyvg"),i("pIFo"),i("f3/d");var a=i("yO6P"),n=i("Yfch");function s(e){return(s="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var r={},o=function(e){a.a.hasOwnProperty(e)&&(r[e]=function(t){return[{validator:(i=e,r=a.a[i]||"",function(e,t,i){var a,o,c;e.ops&&"object"===s(e.ops)?(e.ops.len?a=o=e.ops.len-0:(a=Object(n.b)(e.ops.min)?e.ops.min:0,o=Object(n.b)(e.ops.max)?e.ops.max:0),c=o>=a?a+","+(o||""):"0,",r=e.ops.customReg&&"string"==typeof e.ops.customReg?e.ops.customReg:r.replace(/placeholder/g,c)):r=r.replace(/placeholder/g,"0,"),t?new RegExp(r,"g").test(t)?i():i(" "):i()}),trigger:"change",ops:t}];var i,r})};for(var c in a.a)o(c);t.a=r},uTIz:function(e,t,i){"use strict";i("rE2o"),i("ioFf"),i("pIFo"),i("91GP"),i("rGqo"),i("f3/d");var a=i("z0WU"),n=i("WwWg"),s=i("lNSx"),r=i("QWlu");function o(e){return(o="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var c={components:{searchTree:function(){return i.e("chunk-be27").then(i.bind(null,"VASZ"))},searchTable:function(){return i.e("chunk-13df").then(i.bind(null,"wlEh"))},treeAndTable:function(){return i.e("chunk-6f21").then(i.bind(null,"Aqwb"))}},name:"search-bar",props:{searchList:{type:Array,default:function(){return[]}},searchMethod:{type:Object,default:function(){return{}}},searchConfig:{type:Object,default:function(){return{}}},searchBtns:{type:Array,default:function(){return[]}}},data:function(){return{hideTime:500,clientHeight:0,dynaHeightTimer:null,formData:{code:"",name:"",isdisable:""},topBarBtnList:[{name:"查询",icon:"search",state:!1,method:this.queryData,isShow:!0},{name:"重置",icon:"refresh",state:!1,plain:!0,method:this.resetQuery,isShow:!0}],searchMap:{},searchLabelWidth:0,upIndex:0,closeSearchBoxUpdate:!0,guid:"",createTime:0,inMain:!1,asynSearchList:["cascader"],magnifierData:{},searchStyleTimer:"",clientDataTimer:"",arrowState:null}},created:function(){this.createStore(),this.guid=Object(n.a)(),this.$emit("send-guid",this.guid),Object(n.d)(this),this.createTime=(new Date).getTime()},mounted:function(){var e=this;/^[el\-]/.test(this.$el.parentNode.parentNode.className)?this.inMain=!1:this.inMain=!0,this.inMain&&this.$store.commit(this.guid+"/SET_CLIENTDATA",{clientHeight:this.$el.parentNode.clientHeight,clientWidth:this.$el.parentNode.clientWidth,rootWidth:this.$root.$el.clientWidth,rootHeight:this.$root.$el.clientHeight}),this.inMain&&!this.searchConfig.hideSearchSwitch?(this.$store.commit(this.guid+"/SET_DYNAHEIGHTSTATE",this.$storage.get("dynaHeightState")||"1"),this.arrowState=this.$storage.get("dynaHeightState")||"1"):this.$store.commit(this.guid+"/SET_ARROWBTN",20),this.$nextTick(function(t){e.setSearchLabelWidth(),r.a.on(window,"resize",e.resizeFn),setTimeout(function(t){e.$store.commit(e.guid+"/SET_SEARCHHEIGHT",e.$refs.searchFrom.$el.clientHeight)},10)})},updated:function(){},beforeDestroy:function(){Object(n.g)(this.$store,this.guid),r.a.off(window,"resize",this.resizeFn)},methods:{resizeFn:function(){var e=this;clearTimeout(e.clientDataTimer),e.clientDataTimer=setTimeout(function(t){e.$nextTick(function(t){e.$store.commit(e.guid+"/SET_CLIENTDATA",{clientHeight:e.$el.parentNode.clientHeight,clientWidth:e.$el.parentNode.clientWidth,rootWidth:e.$root.$el.clientWidth,rootHeight:e.$root.$el.clientHeight}),setTimeout(function(t){e.$store.commit(e.guid+"/SET_SEARCHHEIGHT",e.$refs.searchFrom.$el.clientHeight)},10)})},300)},changeComponent:function(e,t){this.magnifierData[e.mapKey+"Dialog"+t]=!0,this.magnifierData[e.mapKey+"Visible"+t]=!0},closeDialog:function(e,t){e?(this.magnifierData[t.mapKey+"Visible"+t.keyIndex]=!1,this.magnifierData[t.mapKey+"Dialog"+t.keyIndex]=!1,"table"===t.dialogType||"treeAndTable"===t.dialogType?this.searchMap[t.mapKey]=e.length?e[0].name:"":this.searchMap[t.mapKey]=e.nodeData?e.nodeData.name:""):(this.magnifierData[t.mapKey+"Visible"+t.keyIndex]=!1,this.magnifierData[t.mapKey+"Dialog"+t.keyIndex]=!1,this.searchMap[t.mapKey]="")},createStore:function(){var e=this;this.searchList.forEach(function(t,i){e.asynSearchList.indexOf(t.type)>-1&&Object(n.e)(e,t.configs)})},setSearchLabelWidth:function(){var e=0,t=this.$refs.searchFrom?this.$refs.searchFrom.$el.querySelectorAll(".el-form-item"):[];(t=[].slice.call(t)).length&&(t.forEach(function(t){var i=t.querySelector(".el-form-item__label");e<i.clientWidth&&(e=i.clientWidth)}),this.searchLabelWidth=e)},resetDynaHeight:function(){var e=this;e.closeSearchBoxUpdate=!1,e.dynaHeightState-0?(e.$storage.remove("dynaHeightState"),e.$storage.set("dynaHeightState","0"),e.$store.commit(e.guid+"/SET_DYNAHEIGHTSTATE","0"),clearTimeout(e.dynaHeightTimer),e.dynaHeightTimer=setTimeout(function(){e.arrowState="0"},e.hideTime)):e.dynaHeightState-0||(e.$storage.remove("dynaHeightState"),e.$storage.set("dynaHeightState","1"),e.$store.commit(e.guid+"/SET_DYNAHEIGHTSTATE","1"),clearTimeout(e.dynaHeightTimer),e.dynaHeightTimer=setTimeout(function(){e.arrowState="1"},e.hideTime))},queryData:function(){var e=this;e.$refs.searchFrom.validate(function(t){if(t)if(e.searchMethod.api){var i=Object.assign({},e.searchMap,e.searchMethod.data);e.$axios.post(e.searchMethod.api,i).then(function(t){e.$emit("search-res",t),e.$loading().close()})}else e.$emit("search-map",e.searchMap)})},resetQuery:function(){for(var e in this.searchMap){var t=o(this.searchMap[e]);this.searchMap[e]="string"===t||"number"===t||"boolean"===t?"":"object"===t?Array.isArray(this.searchMap[e])?[]:{}:"function"===t?function(e){}:""}this.$emit("search-map",this.searchMap)},cascaderChange:function(){}},computed:{sys:function(){return this.$store.getters.systemInfo},size:function(){return this.$store.getters.size},searchBoxHeight:function(){return this.$store.getters[this.guid+"/searchBoxHeight"]},dynaHeight:function(){return this.$store.getters[this.guid+"/dynaHeight"]},dynaHeightState:function(){return this.$store.getters[this.guid+"/dynaHeightState"]},clientData:function(){return this.$store.getters[this.guid+"/clientData"]},clientWidth:function(){var e=0;return this.inMain||(e=41),this.clientData?this.clientData.clientWidth-e:"auto"},setFormContentWidth:function(){return this.clientData.rootWidth<=1024?120:this.clientData.rootWidth>1024&&this.clientData.rootWidth<=1280?120:this.clientData.rootWidth>1280&&this.clientData.rootWidth<=1440?140:180},setFormItemWidth:function(){return this.setFormContentWidth+this.searchLabelWidth+"px"},searchBtnClass:function(){if(!this.inMain)return"stand";var e=this.clientData?this.clientData.rootWidth:1024;return e>1600?this.searchList.length>6?"stand":"flat":1600>=e&&e>1440?this.searchList.length>5?"stand":"flat":1440>=e&&e>1280?this.searchList.length>4?"stand":"flat":1280>=e&&e>1024?this.searchList.length>3?"stand":"flat":1024>=e?this.searchList.length>3?"stand":"flat":void 0},searchBtnWidth:function(){return this.inMain?"stand"===this.searchBtnClass?this.clientWidth-100:this.clientWidth-200:this.clientWidth-100.5},dateFormat:function(){return function(e){var t=e.configs.type;return"week"===t?"yyyy 第 WW 周":"month"===t?"yyyy-MM":"year"===t?"yyyy":"yyyy-MM-dd"}},datePickerOptions:function(){return function(e){if(!e||!e.disabledDate)return e&&e.hidePicker?void 0:{shortcuts:[{text:"今天",onClick:function(e){e.$emit("pick",new Date)}},{text:"明天",onClick:function(e){var t=new Date;t.setTime(t.getTime()+864e5),e.$emit("pick",t)}}]};if(Array.isArray(e.disabledDate)&&e.disabledDate.length){var t=Object(a.f)(e.disabledDate[0]),i=Object(a.f)(e.disabledDate[1]);return{disabledDate:function(e){return t&&i?t>e.getTime()||i<e.getTime():t&&!i?t>e.getTime():i&&!t?i<e.getTime():void 0},shortcuts:[{text:"今天",onClick:function(e){e.$emit("pick",new Date)}},{text:"明天",onClick:function(e){var t=new Date;t.setTime(t.getTime()+864e5),e.$emit("pick",t)}}]}}}},fromRules:function(){var e=this;if(this.searchList.length){var t={};return this.searchList.forEach(function(i){i.ruleType&&e.searchMap[i.mapKey]&&s.a[i.ruleType]&&(t[i.mapKey]=s.a[i.ruleType](i.ruleOps?i.ruleOps:null))}),t}return{}},searchBtnList:function(){return this.searchBtns.length?(this.searchBtns[0]&&(this.searchBtns[0].method=this.queryData),this.searchBtns[1]&&(this.searchBtns[1].method=this.resetQuery),this.searchBtns):this.topBarBtnList},cascaderOps:function(){var e=this;return function(t,i){return e.$store.getters[t.apiName+"/dataList"]}},magnifierDialog:function(){var e=this;return function(t,i){return void 0===e.magnifierData[t.mapKey+"Dialog"+i]&&e.$set(e.magnifierData,t.mapKey+"Dialog"+i,!1),e.magnifierData[t.mapKey+"Dialog"+i]}},dialogProp:function(){return function(e,t){return e.configs.dialogType.indexOf("And")>-1?e.configs.dialogType:"search"+e.configs.dialogType.replace(/( |^)[a-z]/g,function(e){return e.toUpperCase()})}},dialogData:function(){return function(e,t){return e.configs.mapKey=e.mapKey,e.configs.keyIndex=t,e.configs}},visible:function(){var e=this;return function(t,i){return void 0===e.magnifierData[t.mapKey+"Visible"+i]&&e.$set(e.magnifierData,t.mapKey+"Visible"+i,!1),e.magnifierData[t.mapKey+"Visible"+i]}}},watch:{searchMap:{handler:function(e,t){var i=!1,a=[];for(var n in e)this.fromRules[n]&&!e[n]&&a.push(n),e[n]&&(i=!0);this.$refs.searchFrom.clearValidate(a),this.inMain||i||this.$emit("search-map",null)},deep:!0}}},l=(i("Z1wF"),i("KHd+")),h=Object(l.a)(c,function(){var e=this,t=e.$createElement,i=e._self._c||t;return e.searchList.length?i("div",{staticClass:"searchBar",style:{padding:e.inMain?0:"0 10px"}},[i("el-row",{staticStyle:{"box-sizing":"border-box",position:"relative",overflow:"hidden",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:e.dynaHeight+"px"}},[i("div",{staticStyle:{position:"absolute",top:"0",left:"0",right:"0"},style:{height:e.searchBoxHeight+"px"}},[i("div",{staticStyle:{float:"left",height:"100%"},style:{width:e.searchBtnWidth+"px"}},[i("el-form",{ref:"searchFrom",class:{inDialog:!e.inMain,dynaFrom:"mini"!==e.size},style:{padding:"mini"===e.size&&e.searchList.length<7?"10px 0":""},attrs:{inline:"",model:e.searchMap,rules:e.fromRules,"label-position":"left","label-width":e.searchLabelWidth?e.searchLabelWidth+"px":"auto",size:e.size}},[e._l(e.searchList,function(t,a){return["input"===t.type?[i("el-form-item",{key:a,style:{"min-width":e.setFormItemWidth,"max-width":e.setFormItemWidth},attrs:{label:t.label?t.label:"未定义",prop:t.mapKey}},[i("el-input",{attrs:{type:t.configs.type,placeholder:t.placeholder,disabled:t.configs.disabled,clearable:!1!==t.configs.clearable||t.configs.clearable},model:{value:e.searchMap[t.mapKey],callback:function(i){e.$set(e.searchMap,t.mapKey,i)},expression:"searchMap[item.mapKey]"}})],1)]:"select"===t.type?[i("el-form-item",{key:a,style:{"min-width":e.setFormItemWidth,"max-width":e.setFormItemWidth},attrs:{label:t.label?t.label:"未定义",prop:t.mapKey}},[i("el-select",{attrs:{name:t.configs.name,disabled:t.configs.disabled,clearable:!1!==t.configs.clearable||t.configs.clearable,multiple:t.configs.multiple,filterable:t.configs.filterable,"default-first-option":t.configs["default-first-option"],placeholder:t.placeholder},model:{value:e.searchMap[t.mapKey],callback:function(i){e.$set(e.searchMap,t.mapKey,i)},expression:"searchMap[item.mapKey]"}},e._l(t.configs.options,function(e){return i("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})}),1)],1)]:"date"===t.type?[i("el-form-item",{key:a,style:{"max-width":"daterange"===t.configs.type?"320px":e.setFormItemWidth,"min-width":"daterange"===t.configs.type?"320px":e.setFormItemWidth},attrs:{label:t.label?t.label:"未定义",prop:t.mapKey}},[i("el-date-picker",{attrs:{type:t.configs.type?t.configs.type:"date","range-separator":"daterange"===t.configs.type?"至":"","start-placeholder":"开始日期","end-placeholder":"结束日期","unlink-panels":"",editable:!!t.configs.editable&&t.configs.editable,format:e.dateFormat(t),"value-format":"week"===t.configs.type?"":e.dateFormat(t),placeholder:"选择日期","picker-options":e.datePickerOptions(t.configs.pickerOptions)},model:{value:e.searchMap[t.mapKey],callback:function(i){e.$set(e.searchMap,t.mapKey,i)},expression:"searchMap[item.mapKey]"}})],1)]:"time"===t.type?[i("el-form-item",{key:a,style:{"min-width":e.setFormItemWidth,"max-width":e.setFormItemWidth},attrs:{label:t.label?t.label:"未定义",prop:t.mapKey}},[t.configs.pickerOptions.start&&t.configs.pickerOptions.end&&t.configs.pickerOptions.step?i("el-time-select",{attrs:{editable:!!t.configs.editable&&t.configs.editable,"value-format":"HH:mm:ss","picker-options":t.configs.pickerOptions,placeholder:t.placeholder},model:{value:e.searchMap[t.mapKey],callback:function(i){e.$set(e.searchMap,t.mapKey,i)},expression:"searchMap[item.mapKey]"}}):i("el-time-picker",{attrs:{editable:!!t.configs.editable&&t.configs.editable,"value-format":"HH:mm:ss","picker-options":t.configs.pickerOptions,placeholder:t.placeholder},model:{value:e.searchMap[t.mapKey],callback:function(i){e.$set(e.searchMap,t.mapKey,i)},expression:"searchMap[item.mapKey]"}})],1)]:"dateTime"===t.type?void 0:"cascader"===t.type?[i("el-form-item",{key:a,style:{"min-width":e.setFormItemWidth,"max-width":e.setFormItemWidth},attrs:{label:t.label?t.label:"未定义",prop:t.mapKey}},[i("el-cascader",{attrs:{filterable:void 0===t.configs.filterable||t.configs.filterable,clearable:void 0===t.configs.clearable||t.configs.clearable,props:t.configs.props?t.configs.props:{},"expand-trigger":t.configs.expand?t.configs.expand:"hover","show-all-levels":!!t.configs.showLevels&&t.configs.showLevels,"change-on-select":!!t.configs.onChange&&t.configs.onChange,options:t.configs.apiName&&t.configs.params?e.cascaderOps(t.configs,a):t.configs.options&&t.configs.options.length?t.configs.options:[]},on:{change:e.cascaderChange},model:{value:e.searchMap[t.mapKey],callback:function(i){e.$set(e.searchMap,t.mapKey,i)},expression:"searchMap[item.mapKey]"}})],1)]:"magnifier"===t.type?[i("el-form-item",{key:a,staticClass:"magnifier",style:{"min-width":e.setFormItemWidth,"max-width":e.setFormItemWidth},attrs:{label:t.label?t.label:"未定义",prop:t.mapKey}},[i("el-input",{attrs:{placeholder:t.placeholder,disabled:""},model:{value:e.searchMap[t.mapKey],callback:function(i){e.$set(e.searchMap,t.mapKey,i)},expression:"searchMap[item.mapKey]"}},[i("el-button",{attrs:{slot:"append",icon:"el-icon-search"},on:{click:function(i){e.changeComponent(t,a)}},slot:"append"})],1),e._v(" "),e.magnifierDialog(t,a)?i(e.dialogProp(t,a),{tag:"component",attrs:{initData:e.dialogData(t,a),visible:e.visible(t,a)},on:{"close-dialog":e.closeDialog}}):e._e()],1)]:e._e()]})],2)],1),e._v(" "),i("div",{class:[e.searchBtnClass],staticStyle:{float:"right",height:"100%"}},[i("div",{staticStyle:{height:"100%"}},[e.inMain?e._l(e.searchBtnList,function(t,a){return[i("base-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"item.isShow"}],key:a,attrs:{name:t.name,icon:t.icon,plain:t.plain,size:t.size||e.size,state:t.state},on:{myclick:t.method}})]}):[i("base-button",{directives:[{name:"show",rawName:"v-show",value:e.searchBtnList[0].isShow,expression:"searchBtnList[0].isShow"}],attrs:{name:e.searchBtnList[0].name,icon:e.searchBtnList[0].icon,plain:e.searchBtnList[0].plain,state:e.searchBtnList[0].state,size:e.searchBtnList[0].size||e.size},on:{myclick:e.searchBtnList[0].method}})]],2)])])]),e._v(" "),(e.searchConfig.hideSearchSwitch?!e.searchConfig.hideSearchSwitch:e.inMain)?i("el-row",{staticStyle:{position:"relative",height:"20px"}},[i("div",{staticStyle:{position:"absolute",bottom:"10px",left:"0",right:"0",height:"1px","background-color":"rgb(228,228,228)","z-index":"10"}},[i("div",{staticStyle:{position:"relative"}},[i("el-tooltip",{attrs:{effect:"dark",content:e.arrowState-0?"收起搜索":"展开搜索",placement:"bottom","hide-after":e.hideTime}},[e.arrowState-0?i("el-button",{staticStyle:{position:"absolute",left:"50%",top:"-10.5px",transform:"translate(-50%,0)",width:"1.5em",height:"1.5em",padding:"0"},attrs:{icon:"el-icon-arrow-up",circle:""},on:{click:e.resetDynaHeight}}):i("el-button",{staticStyle:{position:"absolute",left:"50%",top:"-10.5px",transform:"translate(-50%,0)",width:"1.5em",height:"1.5em",padding:"0"},attrs:{icon:"el-icon-arrow-down",circle:""},on:{click:e.resetDynaHeight}})],1)],1)])]):e._e()],1):e._e()},[],!1,null,null,null);h.options.__file="index.vue";t.a=h.exports}}]);