(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-5d2f"],{VpK9:function(e,t,n){"use strict";var a=n("lb49");n.n(a).a},lb49:function(e,t,n){},xoKt:function(e,t,n){"use strict";n.r(t);n("yt8O"),n("RW0V"),n("f3/d"),n("rGqo");var a=n("uTIz"),i=n("K3g7"),o=n("6Q2N"),s=n("Vobf"),r=n("z0WU"),l=n("mSNy");function c(e,t,n){return t in e?Object.defineProperty(e,t,{value:n,enumerable:!0,configurable:!0,writable:!0}):e[t]=n,e}var u={components:{searchBar:a.a},data:function(){return{guid:"",searchList:[{label:"货品编码",type:"input",ruleType:"string",mapKey:"productCode",configs:{},placeholder:"货品编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"productName",configs:{},placeholder:"货品名称"},{label:"规格型号",type:"input",ruleType:"string",mapKey:"productSpec",configs:{},placeholder:"规格型号"},{label:"距今天数",type:"input",ruleType:"number",mapKey:"last2nowDay",configs:{},placeholder:"距今天数"},{label:"排序方式",type:"select",ruleType:"number",mapKey:"orderLast2nowDay",configs:{clearable:!0,name:"",options:[{value:"all",label:"全部"},{value:"desc",label:"降序"},{value:"asc",label:"升序"}]},placeholder:"请选择"}],searchConfig:{hideSearchSwitch:!1},openDialogName:"",showDialog:!1,visible:!1,dialogData:{title:"",temp:null,tempLable:null,nodeId:null},initConfigs:{tableOperates:{}},configs:{},treeData:[],treeConfigs:{ref:"tree",showCheckBox:!1,showIcons:!1},selectTree:{pid:"",id:"",name:""},tableData:[],selectList:null,temp:{},tempQuery:{},tempLable:{},pageData:null,pageNo:1}},beforeCreate:function(){},created:function(){this.initButtons(),this.initTree()},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{searchMap:function(e){this.tempQuery=e,this.pageNo=1,this.initTable(null,this.selectTree.id)},sendGuid:function(e){this.guid=e},closeDialog:function(e){this.showDialog=!1,"ok"===e.resState&&this.initTree()},initButtons:function(){var e=this,t=e.$storage.get("userInfo").roleIds,n=e.$storage.get("menuId");t&&(e.$loading({spinner:"none",text:"云上企业"}),Object(s.initMenuButtons)({menuId:n,roleId:t}).then(function(t){var n=t.buttonList;n&&n.forEach(function(t){if(e.initConfigs&&e.initConfigs.tableOperates)for(var n in e.initConfigs.tableOperates)n.indexOf(t.nameEn)>=0&&n.indexOf("isShow")>0&&(e.initConfigs.tableOperates[n]=!1);if(e.customColumn)for(var a in e.customColumn)if(a){var i=e.customColumn[a];i.length>0&&i.forEach(function(e){if(e)for(var n in e)n.indexOf(t.nameEn)>=0&&n.indexOf("isShow")>0&&(e[n]=!1)})}e.configs&&(e.configs.queryBarBtnList&&e.configs.queryBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)}),e.configs.topBarBtnList&&e.configs.topBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(console.log(e),e.isShow=!1)}))})}).catch(function(t){console.log(t),e.$loading().close()}))},initTree:function(){var e=this;Object(i.treeWarehouse)({id:"2d75e49bcb9911e884ad00163e105f05",isNotNeedSpare:"true",isNeedEntity:"true"}).then(function(t){var n=[],a=t.result.treeList;e.selectTree={pid:a.pid,id:a.id,layer:a.layer,name:a.name,virtualGenre:a.virtualGenre},n.push(a),e.treeData=n,e.initTable(!0,e.selectTree.id),e.$nextTick(function(){e.$refs.tree.$children[0].setCurrentKey(e.selectTree.id)})}).catch(function(t){e.$loading().close()})},treeDataBridge:function(e){this.selectTree={pid:e.nodeData.pid,id:e.nodeData.id,layer:e.nodeData.layer,name:e.nodeData.name,pathId:e.nodeData.pathId},this.pageNo=1,this.initTable(null,this.selectTree.id)},initTable:function(e,t){var n=this;Object(o.findWarehouseInitialBySimple)(function(e){for(var t=1;t<arguments.length;t++){var n=null!=arguments[t]?arguments[t]:{},a=Object.keys(n);"function"==typeof Object.getOwnPropertySymbols&&(a=a.concat(Object.getOwnPropertySymbols(n).filter(function(e){return Object.getOwnPropertyDescriptor(n,e).enumerable}))),a.forEach(function(t){c(e,t,n[t])})}return e}({},n.tempQuery,{fieldCode:"warehouseName,productCode,productName,productSpec,productGenreName,stockCount,lastUpdateDate,last2nowDay",nodeId:t,stockCountQuery:"stockCountNotZero",isNeedEntity:"true",isNeedNotInWarehouseSpare:"true",orderStr:"prodLastDate.last2nowDay desc",dataType:this.$storage.get("dataType"),pageNo:n.pageNo})).then(function(t){n.getListPage(t),e&&n.$loading().close()}).catch(function(e){n.$loading().close()})},getListPage:function(e){if(e){this.pageData=e.result.pageData,this.initTempData(e.result.titles);var t=Object(r.n)(e.result),n=this.addTableTitle(t);this.configs.tableConfigs=n,this.configs.showCheckBox=!0,this.configs.showIndex=!0,this.tableData=e.result.varList,this.configs.topBarBtnList.forEach(function(e){"delete"==e.nameEn&&(e.state=!0)})}},initTempData:function(e){var t=this;e.forEach(function(e){for(var n in e){var a=e[n];a.indexOf("_")>0&&("en"==l.a.locale?a=a.substring(a.indexOf("_")+1):"zh"==l.a.locale&&(a=a.substring(0,a.indexOf("_")))),t.tempLable[n]=a}})},addTableTitle:function(e){return e.forEach(function(e){var t=e.label;t.indexOf("_")>0&&("en"==l.a.locale?e.label=t.substring(t.indexOf("_")+1):"zh"==l.a.locale&&(e.label=t.substring(0,t.indexOf("_"))))}),this.internationalConfig(),e},internationalConfig:function(){"en"==l.a.locale?this.initConfigs.tableOperates.label="OPERATE":"zh"==l.a.locale&&(this.initConfigs.tableOperates.label="操作")},dataBridge:function(e){this.selectList=e,e.length?this.configs.topBarBtnList.forEach(function(e){"delete"==e.nameEn&&(e.state=!1)}):this.configs.topBarBtnList.forEach(function(e){"delete"==e.nameEn&&(e.state=!0)})}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{pageNo:function(){this.initTable(null,this.selectTree.id)}}},d=(n("VpK9"),n("KHd+")),f=Object(d.a)(u,function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"productSluggishBySimple"},[e.searchList.length?n("search-bar",{attrs:{searchList:e.searchList,searchConfig:e.searchConfig},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),n("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:e.tableHeight+"px"}},[n("el-col",{staticClass:"treeStyle",attrs:{span:4}},[n("base-tree",{ref:"tree",attrs:{data:e.treeData,treeConfigs:e.treeConfigs},on:{treedatabridge:e.treeDataBridge}})],1),e._v(" "),n("el-col",{staticClass:"tableStyle",attrs:{span:20}},[n("div",{staticClass:"baseTable"},[n("el-row",{staticClass:"tableContent"},[n("base-table",{attrs:{data:e.tableData,colConfigs:e.configs.tableConfigs,showCheckBox:e.configs.showCheckBox,showIndex:e.configs.showIndex,pageData:e.pageData,currentpage:e.pageNo},on:{databridge:e.dataBridge,"update:currentpage":function(t){e.pageNo=t}}})],1)],1)])],1),e._v(" "),e.showDialog?n(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.visible},on:{"close-dialog":e.closeDialog}}):e._e()],1)},[],!1,null,null,null);f.options.__file="index.vue";t.default=f.exports}}]);