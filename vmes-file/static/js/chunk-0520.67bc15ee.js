(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-0520"],{"6gk9":function(t,e,a){},QSvI:function(t,e,a){},lX1r:function(t,e,a){"use strict";a("INYr"),a("91GP"),a("rGqo"),a("xfY5");var n,i=a("z0WU"),s=a("Yfch");function r(t,e,a){return e in t?Object.defineProperty(t,e,{value:a,enumerable:!0,configurable:!0,writable:!0}):t[e]=a,t}var o={name:"children-table",components:{childrenTable:u},props:{data:{type:Array,default:function(){return[]}},colConfigs:{type:Array,default:function(){return[]}},layer:{type:Number,default:2},maxLayer:{type:Number,default:2},sets:{type:Object,default:function(){return{}}},parentData:{type:Array,default:function(){return[]}},childrenData:{type:Object,default:function(){return{}}},pageData:{type:Object,default:function(){return{}}},guid:{type:String,default:""},rowChain:{type:Array,default:function(){return[]}},isLoading:{type:Boolean,default:!0},defaultExpandAll:[Boolean]},data:function(){return{fixedState:!1,fixedList:[],expandRowKeys:[],childrenConfigs:{},getRowKey:function(t){return t.id},selectable:function(t,e){return"1"===t.rowState},setRowChain:[],currentpage:1,elTimer:""}},computed:(n={setConfigs:function(){return this.sets},configs:function(){return this.setConfigs[this.layer]||{}},childrenLayer:function(){return this.layer+1},setTableRef:function(){return"childTable"+this.layer},formatedData:function(){return this.$emit("do-layout"),this.data},setLoadings:function(){var t=[];return this.formatedData.forEach(function(e){t.push(!1)}),t},setLoading:function(){return this.isLoading},setMaxLayer:function(){return this.maxLayer}},r(n,"setLoadings",function(){var t=[];return this.data.forEach(function(e){t.push(!1)}),t}),r(n,"setPageData",function(){return this.pageData}),r(n,"showPageData",function(){return parseInt(this.setPageData.total)/parseInt(this.setPageData.size)>1}),r(n,"setGuid",function(){return this.guid}),r(n,"childrenKey",function(){return this.$store.getters[this.setGuid+"/keyList"][this.layer-1].childrenKey||"children"}),r(n,"configKey",function(){return this.$store.getters[this.setGuid+"/keyList"][this.layer-1].configKey||"colConfig"}),r(n,"layerKey",function(){return this.$store.getters[this.setGuid+"/keyList"][this.layer-1].layerKey||"layer"}),r(n,"selectionLayer",function(){return this.$store.getters[this.guid+"/selectionLayer"]}),r(n,"selectionList",function(){return this.$store.getters[this.guid+"/selectionList"]}),n),created:function(){var t=this;this.setRowChain=this.rowChain.concat(this.parentData),this.selectionList.length&&(this.selectionLayer!=this.layer?this.formatedData.forEach(function(t){t.rowState="0"}):this.configs.isSingle?this.selectionList.forEach(function(e){t.formatedData.forEach(function(t){e.id!=t.id&&(t.rowState="0")})}):this.formatedData.forEach(function(t){t.rowState="1"}))},mounted:function(){},watch:{configs:function(){console.log(this.configs)},childrenData:function(){},formatedData:function(){var t=this;this.configs.isSingle&&(clearTimeout(this.elTimer),this.elTimer=setTimeout(function(e){t.$refs[t.setTableRef].$el.querySelector(".el-table__header-wrapper .el-checkbox").style.display="none"},10))},selectionLayer:function(){var t=this;this.selectionLayer!=this.layer?this.selectionList.length?this.formatedData.forEach(function(t){t.rowState="0"}):this.formatedData.forEach(function(t){t.rowState="1"}):this.configs.isSingle&&this.selectionList.length?this.selectionList.forEach(function(e){t.formatedData.forEach(function(t){e.id!=t.id&&(t.rowState="0")})}):this.formatedData.forEach(function(t){t.rowState="1"})}},methods:{indexMethod:function(t){return t+1},expandChange:function(t,e){var a=this;e.some(function(e){return e.id===t.id})&&(this.configs.expandOne&&this.toggleRowExpands(e,t),t[this.childrenKey].length||this.sendChildrenRow(t,this.childrenLayer,this.setRowChain,this.layerKey,1),this.setLoadings[this.getRowIndex(t)]=!0),this.$refs[this.setTableRef].setCurrentRow(t),this.$refs[this.setTableRef].$nextTick(function(t){a.$refs[a.setTableRef].doLayout()})},getRowIndex:function(t){return this.formatedData.findIndex(function(e){return t.id===e.id})},toggleRowExpands:function(t,e){var a=this;t.forEach(function(t){a.$refs[a.setTableRef].toggleRowExpansion(t,t.id===e.id)})},getListPage:function(t,e,a){if(t){t.result.titles="string"==typeof t.result.titles?JSON.parse(t.result.titles):t.result.titles,t.result.varList="string"==typeof t.result.varList?JSON.parse(t.result.varList):t.result.varList,t.result.pageData="string"==typeof t.result.pageData?JSON.parse(t.result.pageData):t.result.pageData;var n=Object(i.m)(t.result);return{titleList:this.addTableTitle(n,e,a),pageData:t.result.pageData,tableData:t.result.varList}}return{}},addTableTitle:function(t,e,a){return e[a]&&Array.isArray(e[a])&&e[a].forEach(function(e){Object(s.a)(e.columnIndex)?t.splice(e.columnIndex,0,e):"first"===e.columnIndex?t.unshift(e):"last"===e.columnIndex?t.push(e):t.some(function(t){if(t.prop===e.columnIndex)return Object.assign(t,e),!0})}),t},selectItem:function(t,e){var a=this;this.$emit("databridge",{selection:t,layer:this.layer,baseList:this.formatedData}),setTimeout(function(){a.configs.isSingle&&(t.length?(a.data.forEach(function(t){t.rowState="0"}),t[0].rowState="1"):a.data.forEach(function(t){t.rowState="1"}))},20)},selectAllItem:function(t){if(this.configs.isSingle){if(t.length){for(var e=t.length-1;e>=0;e--)t.splice(e,1);console.log(t)}}else this.$emit("databridge",{selection:t,layer:this.layer,baseList:this.formatedData})},sendChildrenRow:function(t,e,a,n,i){this.$emit("send-children-row",t,e,a,n,i)},handleCurrentChange:function(t){console.log(this.setRowChain),console.log(t),this.currentpage=t,this.changePage({currentpage:this.currentpage,rowChain:this.setRowChain})},doLayout:function(){this.$emit("do-layout")},databridge:function(t){this.$emit("databridge",t)},changePage:function(t){this.$emit("change-page",t)}}},l=(a("v0Ex"),a("KHd+")),c=Object(l.a)(o,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"childrens"},[a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.setLoading,expression:"setLoading"}],ref:t.setTableRef,attrs:{data:t.formatedData,stripe:"",border:"",fit:"","highlight-current-row":"","tooltip-effect":"dark","row-key":t.getRowKey,"expand-row-keys":t.expandRowKeys},on:{"expand-change":t.expandChange,select:t.selectItem,"select-all":t.selectAllItem}},[t.layer<t.setMaxLayer?[t.formatedData.length?a("el-table-column",{attrs:{type:"expand",width:"55",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("children-table",{attrs:{data:e.row[t.childrenKey],layer:t.childrenLayer,isLoading:e.row._loading&&!t.defaultExpandAll,colConfigs:e.row[t.configKey],pageData:e.row.pageData,sets:t.setConfigs,guid:t.setGuid,parentData:[e.row],rowChain:t.setRowChain,maxLayer:t.setMaxLayer,"default-expand-all":t.defaultExpandAll},on:{"send-children-row":t.sendChildrenRow,"do-layout":t.doLayout,databridge:t.databridge,"change-page":t.changePage}})]}}])}):t._e()]:t._e(),t._v(" "),t.configs.showCheckBox&&t.formatedData.length?[a("el-table-column",{attrs:{type:"selection",fixed:t.fixedState,selectable:t.selectable,width:"55",align:"center"}})]:t._e(),t._v(" "),t.configs.showIndex&&t.formatedData.length?[a("el-table-column",{attrs:{type:"index",index:t.indexMethod,fixed:t.fixedState,label:"序号",width:"60",align:"center"}})]:t._e(),t._v(" "),t._l(t.colConfigs,function(e,n){return[e.component?a(e.component,{key:n,tag:"component",attrs:{"col-config":e}}):a("el-table-column",t._b({key:n,attrs:{"show-overflow-tooltip":"",sortable:t.configs.isSortable,label:e.label,align:"center"}},"el-table-column",e,!1))]})],2),t._v(" "),t.showPageData?a("div",{staticClass:"resetPagination",staticStyle:{height:"30px","text-align":"center","margin-top":"5px"}},[a("el-pagination",{staticStyle:{height:"30px"},attrs:{small:"","current-page":t.setPageData.current,"page-size":t.setPageData.size,layout:"prev, pager, next, jumper",total:t.setPageData.total-0},on:{"current-change":t.handleCurrentChange,"update:currentPage":function(e){t.$set(t.setPageData,"current",e)}}})],1):t._e()],1)},[],!1,null,null,null);c.options.__file="childrenTable.vue";var u=c.exports,h={name:"expand-table",props:{initData:{type:Object,default:function(){return{}}},childrenData:{type:Object,default:function(){return{}}},configs:{type:Object,default:function(){return{}}},maxLayer:{type:Number,default:2},apiObj:{type:Object,default:function(){return{}}},updateViewData:{type:Object,default:function(){return{}}},defaultExpandAll:[Boolean]},data:function(){return{wrapperWidth:0,tableWidth:0,fixedList:[],expandRowKeys:[],getRowKey:function(t){return t.id},guid:"",layer:1,tableData:[]}},components:{childrenTable:u},computed:{setTableHeight:function(){return this.showPageData?"calc(100% - 40px)":"100%"},setShowCheckBox:function(){return!!(this.configs[1]&&this.configs[1].showCheckBox&&this.formatedData.length)},setShowIndex:function(){return!!(this.configs[1]&&this.configs[1].showIndex&&this.formatedData.length)},expandOne:function(){return!(!this.configs[1]||!this.configs[1].expandOne)},setLoadings:function(){var t=[];return this.tableData.forEach(function(e){t.push(!1)}),t},formatedData:function(){return this.$store.getters[this.guid+"/dataTree"]||[]},setMaxLayer:function(){return this.maxLayer},childrenKey:function(){return this.$store.getters[this.guid+"/keyList"][this.layer-1].childrenKey||"children"},configKey:function(){return this.$store.getters[this.guid+"/keyList"][this.layer-1].configKey||"colConfig"},layerKey:function(){return this.$store.getters[this.guid+"/keyList"][this.layer-1].layerKey||"layer"},setTitleLists:function(){return this.$store.getters[this.guid+"/baseTitleList"]},setPageData:function(){return this.$store.getters[this.guid+"/basePageData"]},showPageData:function(){return parseInt(this.setPageData.total)/parseInt(this.setPageData.size)>1},selectionLayer:function(){return this.$store.getters[this.guid+"/selectionLayer"]},selectionList:function(){return this.$store.getters[this.guid+"/selectionList"]}},created:function(){this.guid=Object(i.a)(),Object(i.k)(this,this.guid,this.maxLayer)},mounted:function(){},beforeDestroy:function(){Object(i.u)(this.$store,this.guid)},watch:{initData:function(){var t=this;this.formatedData.length&&this.formatedData.forEach(function(e){t.$refs.baseTable.toggleRowExpansion(e,!1)});var e=Object.assign({},this.initData),a=this.getListPage(JSON.parse(JSON.stringify(e.res)),e.customColumn,1);this.$store.commit(this.guid+"/SET_DATATREE",[a,this.layer]),this.$store.commit(this.guid+"/SET_CUSTOMCOL",e.customColumn)},childrenData:function(){var t=Object.assign({},this.childrenData);this.$store.commit(this.guid+"/UPDATA_DATATREE",t)},updateViewData:function(){console.log(this.updateViewData),Object(i.v)(this.updateViewData)}},methods:{selectable:function(t,e){return"1"===t.rowState},expandChange:function(t,e){var a=this;e.some(function(e){return e.id===t.id})&&(this.expandOne&&this.toggleRowExpands(e,t),t[this.childrenKey].length||this.sendChildrenRow(t,this.layer+1,[],this.layerKey,1),this.setLoadings[this.getRowIndex(t)]=!0),this.$refs.baseTable.setCurrentRow(t),this.$refs.baseTable.$nextTick(function(t){a.$refs.baseTable.doLayout()})},getRowIndex:function(t){return this.formatedData.findIndex(function(e){return t.id===e.id})},toggleRowExpands:function(t,e){var a=this;t.forEach(function(t){a.$refs.baseTable.toggleRowExpansion(t,t.id===e.id)})},getListPage:function(t,e,a){if(t){t.result.titles="string"==typeof t.result.titles?JSON.parse(t.result.titles):t.result.titles,t.result.varList="string"==typeof t.result.varList?JSON.parse(t.result.varList):t.result.varList,t.result.pageData="string"==typeof t.result.pageData?JSON.parse(t.result.pageData):t.result.pageData;var n=Object(i.m)(t.result);return{titleList:this.addTableTitle(n,e,a),pageData:t.result.pageData,tableData:t.result.varList}}return{}},addTableTitle:function(t,e,a){return e[a]&&Array.isArray(e[a])&&e[a].forEach(function(e){Object(s.a)(e.columnIndex)?t.splice(e.columnIndex,0,e):"first"===e.columnIndex?t.unshift(e):"last"===e.columnIndex?t.push(e):t.some(function(t){if(t.prop===e.columnIndex)return Object.assign(t,e),!0})}),t},setStyle:function(t){},indexMethod:function(t){return t+1},tableRowClassName:function(t,e){t.index=e},selectItem:function(t,e){this.$emit("databridge",t)},selectAll:function(t){this.$emit("databridge",t)},databridge:function(t){this.$store.commit(this.guid+"/CHANGE_CHECKEDBOXSTATE",t),this.$emit("databridge",this.selectionList)},handleCurrentChange:function(t){this.$emit("update:currentpage",t)},sendChildrenRow:function(t,e,a,n,i){this.$emit("send-children-row",t,e,a,n,i)},doLayout:function(){var t=this;this.$refs.baseTable.$nextTick(function(e){t.$refs.baseTable.doLayout()})},changePage:function(t){console.log(t),Object(i.v)({_that:this,currentpage:t.currentpage,rowChain:t.rowChain})}}},d=(a("pK8k"),Object(l.a)(h,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticStyle:{height:"100%"}},[a("div",{staticClass:"boxStyle",style:{height:t.setTableHeight}},[a("div",{staticClass:"resetTableStyle",staticStyle:{position:"absolute",top:"0",left:"0",right:"0",bottom:"0",overflow:"auto"}},[a("el-table",{ref:"baseTable",staticStyle:{width:"100%"},attrs:{data:t.formatedData,stripe:"",height:"100%",fit:"","highlight-current-row":"","tooltip-effect":"dark","header-cell-class-name":t.setStyle,"row-key":t.getRowKey,"expand-row-keys":t.expandRowKeys,"default-expand-all":t.defaultExpandAll},on:{"expand-change":t.expandChange,select:t.selectItem,"select-all":t.selectAll}},[t.formatedData.length?a("el-table-column",{attrs:{type:"expand",width:"55",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("children-table",{attrs:{data:e.row[t.childrenKey],layer:t.layer+1,isLoading:e.row._loading&&!t.defaultExpandAll,colConfigs:e.row[t.configKey],pageData:e.row.pageData,sets:t.configs,guid:t.guid,parentData:[e.row],rowChain:[],maxLayer:t.setMaxLayer,"default-expand-all":t.defaultExpandAll},on:{"send-children-row":t.sendChildrenRow,"do-layout":t.doLayout,databridge:t.databridge,"change-page":t.changePage}})]}}])}):t._e(),t._v(" "),t.setShowCheckBox?[a("el-table-column",{attrs:{type:"selection",selectable:t.selectable,width:"55",align:"center"}})]:t._e(),t._v(" "),t.setShowIndex?[a("el-table-column",{attrs:{type:"index",index:t.indexMethod,label:"序号",width:"60",align:"center"}})]:t._e(),t._v(" "),t._l(t.setTitleLists,function(e,n){return[e.component?a(e.component,{key:n,tag:"component",attrs:{"col-config":e}}):a("el-table-column",t._b({key:n,attrs:{"show-overflow-tooltip":"",align:"center"}},"el-table-column",e,!1))]})],2)],1)]),t._v(" "),t.showPageData?a("div",{staticStyle:{height:"40px","text-align":"center","margin-top":"5px"}},[a("el-pagination",{attrs:{background:"","current-page":t.setPageData.current,"page-size":t.setPageData.size,layout:"prev, pager, next, jumper",total:t.setPageData.total-0},on:{"current-change":t.handleCurrentChange,"update:currentPage":function(e){t.$set(t.setPageData,"current",e)}}})],1):t._e()])},[],!1,null,null,null));d.options.__file="index.vue";e.a=d.exports},pK8k:function(t,e,a){"use strict";var n=a("QSvI");a.n(n).a},v0Ex:function(t,e,a){"use strict";var n=a("6gk9");a.n(n).a}}]);