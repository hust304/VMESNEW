(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-5d2f"],{VpK9:function(e,t,a){"use strict";var n=a("lb49");a.n(n).a},lb49:function(e,t,a){},xoKt:function(e,t,a){"use strict";a.r(t);a("yt8O"),a("RW0V"),a("f3/d"),a("rGqo");var n=a("uTIz"),i=a("K3g7"),o=a("6Q2N"),s=a("Vobf"),r=a("z0WU"),l=a("mSNy");function c(e,t,a){return t in e?Object.defineProperty(e,t,{value:a,enumerable:!0,configurable:!0,writable:!0}):e[t]=a,e}var u={components:{searchBar:n.a},data:function(){return{guid:"",searchList:[{label:"货品编码",type:"input",ruleType:"string",mapKey:"productCode",configs:{},placeholder:"货品编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"productName",configs:{},placeholder:"货品名称"},{label:"规格型号",type:"input",ruleType:"string",mapKey:"productSpec",configs:{},placeholder:"规格型号"},{label:"距今天数",type:"input",ruleType:"number",mapKey:"last2nowDay",configs:{},placeholder:"距今天数"},{label:"排序方式",type:"select",ruleType:"number",mapKey:"orderLast2nowDay",configs:{clearable:!0,name:"",options:[{value:"all",label:"全部"},{value:"desc",label:"降序"},{value:"asc",label:"升序"}]},placeholder:"请选择"}],searchConfig:{hideSearchSwitch:!1},openDialogName:"",showDialog:!1,visible:!1,dialogData:{title:"",temp:null,tempLable:null,nodeId:null},initConfigs:{tableOperates:{}},configs:{},treeData:[],treeConfigs:{ref:"tree",showCheckBox:!1,showIcons:!1},selectTree:{pid:"",id:"",name:""},tableData:[],selectList:null,temp:{},tempQuery:{},tempLable:{},pageData:null,pageNo:1}},beforeCreate:function(){},created:function(){this.initButtons(),this.initTree()},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{searchMap:function(e){this.tempQuery=e,this.pageNo=1,this.initTable(null,this.selectTree.id)},sendGuid:function(e){this.guid=e},closeDialog:function(e){this.showDialog=!1,"ok"===e.resState&&this.initTree()},initButtons:function(){var e=this,t=e.$storage.get("userInfo").roleIds,a=e.$storage.get("menuId");t&&(e.$loading({spinner:"preloader",text:""}),Object(s.initMenuButtons)({menuId:a,roleId:t}).then(function(t){var a=t.buttonList;a&&a.forEach(function(t){if(e.initConfigs&&e.initConfigs.tableOperates)for(var a in e.initConfigs.tableOperates)a.indexOf(t.nameEn)>=0&&a.indexOf("isShow")>0&&(e.initConfigs.tableOperates[a]=!1);if(e.customColumn)for(var n in e.customColumn)if(n){var i=e.customColumn[n];i.length>0&&i.forEach(function(e){if(e)for(var a in e)a.indexOf(t.nameEn)>=0&&a.indexOf("isShow")>0&&(e[a]=!1)})}e.configs&&(e.configs.queryBarBtnList&&e.configs.queryBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)}),e.configs.topBarBtnList&&e.configs.topBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)}))})}).catch(function(t){e.$loading().close()}))},initTree:function(){var e=this;Object(i.treeWarehouse)({id:"2d75e49bcb9911e884ad00163e105f05",isNotNeedSpare:"true",isNeedEntity:"true"}).then(function(t){var a=[],n=t.result.treeList;e.selectTree={pid:n.pid,id:n.id,layer:n.layer,name:n.name,virtualGenre:n.virtualGenre},a.push(n),e.treeData=a,e.initTable(!0,e.selectTree.id),e.$nextTick(function(){e.$refs.tree.$children[0].setCurrentKey(e.selectTree.id)})}).catch(function(t){e.$loading().close()})},treeDataBridge:function(e){this.selectTree={pid:e.nodeData.pid,id:e.nodeData.id,layer:e.nodeData.layer,name:e.nodeData.name,pathId:e.nodeData.pathId},this.pageNo=1,this.initTable(null,this.selectTree.id)},initTable:function(e,t){var a=this;Object(o.findWarehouseInitialBySimple)(function(e){for(var t=1;t<arguments.length;t++){var a=null!=arguments[t]?arguments[t]:{},n=Object.keys(a);"function"==typeof Object.getOwnPropertySymbols&&(n=n.concat(Object.getOwnPropertySymbols(a).filter(function(e){return Object.getOwnPropertyDescriptor(a,e).enumerable}))),n.forEach(function(t){c(e,t,a[t])})}return e}({},a.tempQuery,{fieldCode:"warehouseName,productCode,productName,productSpec,productGenreName,stockCount,lastUpdateDate,last2nowDay",nodeId:t,stockCountQuery:"stockCountNotZero",isNeedEntity:"true",isNeedNotInWarehouseSpare:"true",orderStr:"prodLastDate.last2nowDay desc",dataType:this.$storage.get("dataType"),pageNo:a.pageNo})).then(function(t){a.getListPage(t),e&&a.$loading().close()}).catch(function(e){a.$loading().close()})},getListPage:function(e){if(e){this.pageData=e.result.pageData,this.initTempData(e.result.titles);var t=Object(r.o)(e.result),a=this.addTableTitle(t);this.configs.tableConfigs=a,this.configs.showCheckBox=!0,this.configs.showIndex=!0,this.tableData=e.result.varList,this.configs.topBarBtnList.forEach(function(e){"delete"==e.nameEn&&(e.state=!0)})}},initTempData:function(e){var t=this;e.forEach(function(e){for(var a in e){var n=e[a];n.indexOf("_")>0&&("en"==l.a.locale?n=n.substring(n.indexOf("_")+1):"zh"==l.a.locale&&(n=n.substring(0,n.indexOf("_")))),t.tempLable[a]=n}})},addTableTitle:function(e){return e.forEach(function(e){var t=e.label;t.indexOf("_")>0&&("en"==l.a.locale?e.label=t.substring(t.indexOf("_")+1):"zh"==l.a.locale&&(e.label=t.substring(0,t.indexOf("_"))))}),this.internationalConfig(),e},internationalConfig:function(){"en"==l.a.locale?this.initConfigs.tableOperates.label="OPERATE":"zh"==l.a.locale&&(this.initConfigs.tableOperates.label="操作")},dataBridge:function(e){this.selectList=e,e.length?this.configs.topBarBtnList.forEach(function(e){"delete"==e.nameEn&&(e.state=!1)}):this.configs.topBarBtnList.forEach(function(e){"delete"==e.nameEn&&(e.state=!0)})}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{pageNo:function(){this.initTable(null,this.selectTree.id)}}},d=(a("VpK9"),a("KHd+")),f=Object(d.a)(u,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"productSluggishBySimple"},[e.searchList.length?a("search-bar",{attrs:{searchList:e.searchList,searchConfig:e.searchConfig},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),a("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:e.tableHeight+"px"}},[a("el-col",{staticClass:"treeStyle",attrs:{span:4}},[a("base-tree",{ref:"tree",attrs:{data:e.treeData,treeConfigs:e.treeConfigs},on:{treedatabridge:e.treeDataBridge}})],1),e._v(" "),a("el-col",{staticClass:"tableStyle",attrs:{span:20}},[a("div",{staticClass:"baseTable"},[a("el-row",{staticClass:"tableContent"},[a("base-table",{attrs:{data:e.tableData,colConfigs:e.configs.tableConfigs,showCheckBox:e.configs.showCheckBox,showIndex:e.configs.showIndex,pageData:e.pageData,currentpage:e.pageNo},on:{databridge:e.dataBridge,"update:currentpage":function(t){e.pageNo=t}}})],1)],1)])],1),e._v(" "),e.showDialog?a(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.visible},on:{"close-dialog":e.closeDialog}}):e._e()],1)},[],!1,null,null,null);f.options.__file="index.vue";t.default=f.exports}}]);