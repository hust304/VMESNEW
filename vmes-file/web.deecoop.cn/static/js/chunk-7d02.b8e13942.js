(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-7d02"],{LyGo:function(t,e,i){"use strict";var n=i("mys0");i.n(n).a},WM80:function(t,e,i){"use strict";i.r(e);i("yt8O"),i("RW0V"),i("f3/d"),i("rGqo");var n=i("uTIz"),o=i("zDZ1"),a=i("F0s3"),s=i("7TcM"),l=i("mSNy"),r=i("xMja"),c=i("5W5M"),p=i("Vobf"),u=i("z0WU");function d(t){for(var e=1;e<arguments.length;e++){var i=null!=arguments[e]?arguments[e]:{},n=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(n=n.concat(Object.getOwnPropertySymbols(i).filter(function(t){return Object.getOwnPropertyDescriptor(i,t).enumerable}))),n.forEach(function(e){h(t,e,i[e])})}return t}function h(t,e,i){return e in t?Object.defineProperty(t,e,{value:i,enumerable:!0,configurable:!0,writable:!0}):t[e]=i,t}var g={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n      \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n      \t\t\t\t\t\t\t\x3c!--<el-button v-show="colConfig.unitConversion_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.unitConversion(scope.row,scope.$index)">设置单位</el-button>--\x3e\n      \t\t\t\t\t\t\t<el-button v-show="colConfig.productPrice_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.productPrice(scope.row,scope.$index)">设置单价</el-button>\n      \t\t\t\t\t</div>\n\n    \t\t\t\t</el-table-column>'},f={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" width="250" align="center">\n\t\t\t      <div slot-scope="scope">\n    \t\t\t\t\t\t{{scope.row.prodInfo}}\n    \t\t\t\t\t</div>\n    \t\t\t   </el-table-column>'},b={data:function(){return{fieldCode:"code,name,spec,property,unitName,price",guid:"",searchList:[{label:"货品编码",type:"input",mapKey:"code",configs:{},placeholder:"请输入货品编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"name",configs:{},placeholder:"请输入货品名称"},{label:"规格型号",type:"input",ruleType:"string",mapKey:"spec",configs:{},placeholder:"请输入规格型号"},{label:"自定义属性",type:"input",ruleType:"string",mapKey:"property",configs:{},placeholder:"请输入自定义属性"}],searchConfig:{hideSearchSwitch:!1},openDialogName:"",showDialog:!1,visible:!1,dialogData:{title:"",temp:null,tempLable:null},initConfigs:{tableOperates:{prop:"operate",label:"操作",enLabel:"operation",isPropName:!0,component:g,unitConversion:this.unitConversion,unitConversion_isShow:!0,productPrice:this.productPrice,productPrice_isShow:!0}},configs:{topBarBtnList:[{name:"导入",nameEn:"import",isShow:!0,icon:"import",method:this.importExcelCallBack,dialog:{enable:!0,data:{exportUrl:"/fileUpload/excelTemplet/ProductUnitPriceExcelImport.xlsx",importUrl:"/base/productUnit/importExcelProductUnitByProductPrice"},dialogName:"dialogImportExcel"}}],tableConfigs:[],showCheckBox:!1,showIndex:!1},treeData:[],treeConfigs:{ref:"tree",showCheckBox:!1,showIcons:!1},selectTree:{pid:"",id:"",name:""},tableData:[],selectList:null,temp:{},tempQuery:{},tempLable:{},pageData:null,pageNo:1}},components:{searchBar:n.a,dialogQrcode:o.a,dialogUnit:a.default,dialogPrice:s.default},beforeCreate:function(){},created:function(){this.initButtons(),this.initTree()},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{searchMap:function(t){this.tempQuery=t,this.pageNo=1,this.initTable(null,this.selectTree.id)},sendGuid:function(t){this.guid=t},closeDialog:function(t){this.showDialog=!1,"ok"===t.resState&&this.refreshTable()},initButtons:function(){var t=this,e=t.$storage.get("userInfo").roleIds,i=t.$storage.get("menuId");e&&(t.$loading({spinner:"preloader",text:""}),Object(p.initMenuButtons)({menuId:i,roleId:e}).then(function(e){var i=e.buttonList;i&&i.forEach(function(e){if(t.initConfigs&&t.initConfigs.tableOperates)for(var i in t.initConfigs.tableOperates)i.indexOf(e.nameEn)>=0&&i.indexOf("isShow")>0&&(t.initConfigs.tableOperates[i]=!1);if(t.customColumn)for(var n in t.customColumn)if(n){var o=t.customColumn[n];o.length>0&&o.forEach(function(t){if(t)for(var i in t)i.indexOf(e.nameEn)>=0&&i.indexOf("isShow")>0&&(t[i]=!1)})}t.configs&&(t.configs.queryBarBtnList&&t.configs.queryBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}),t.configs.topBarBtnList&&t.configs.topBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}))})}).catch(function(e){t.$loading().close()}))},initTree:function(){var t=this;Object(c.listTreeDictionary)({dictionaryKey:"productGenre"}).then(function(e){var i=[],n=e.result.treeList;t.selectTree={pid:n.pid,id:n.id,layer:n.layer,name:n.name},i.push(n),t.treeData=i,t.initTable(!0,t.selectTree.id),t.$nextTick(function(){t.$refs.tree.$children[0].setCurrentKey(t.selectTree.id)})}).catch(function(e){t.$loading().close()})},treeDataBridge:function(t){this.selectTree={pid:t.nodeData.pid,id:t.nodeData.id,layer:t.nodeData.layer,name:t.nodeData.name},this.pageNo=1,this.initTable(null,this.selectTree.id)},initTable:function(t,e){var i=this;Object(r.listPageProducts)(d({},i.tempQuery,{genreId:e,dataType:this.$storage.get("dataType"),addColumn:{columnKey:"prodInfo",columnName:"货品"},prodColumnKey:"code,name,spec,property",fieldCode:"prodInfo,unitName,price",pageNo:i.pageNo})).then(function(e){i.getListPage(e),t&&i.$loading().close()}).catch(function(t){i.$loading().close()})},getListPage:function(t){if(t){this.pageData=t.result.pageData,this.initTempData(t.result.titles);var e=Object(u.o)(t.result),i=this.addTableTitle(e);this.configs.tableConfigs=i,this.configs.showCheckBox=!0,this.configs.showIndex=!0,this.tableData=t.result.varList,this.configs.topBarBtnList.forEach(function(t){"delete"==t.nameEn&&(t.state=!0)})}},initTempData:function(t){var e=this;t.forEach(function(t){for(var i in t){var n=t[i];n.indexOf("_")>0&&("en"==l.a.locale?n=n.substring(n.indexOf("_")+1):"zh"==l.a.locale&&(n=n.substring(0,n.indexOf("_")))),e.tempLable[i]=n}})},addTableTitle:function(t){return t.forEach(function(t){var e=t.label;e.indexOf("_")>0&&("en"==l.a.locale?t.label=e.substring(e.indexOf("_")+1):"zh"==l.a.locale&&(t.label=e.substring(0,e.indexOf("_")))),"货品"===t.label&&(t.component=f)}),this.internationalConfig(),t.push(this.initConfigs.tableOperates),t},internationalConfig:function(){"en"==l.a.locale?this.initConfigs.tableOperates.label="OPERATE":"zh"==l.a.locale&&(this.initConfigs.tableOperates.label="操作")},changeState:function(t,e){Object(r.updateDisableProduct)(t.id,t.isdisable).then(function(t){}).catch(function(t){})},dataBridge:function(t){this.selectList=t},importExcelCallBack:function(){this.refreshTable()},unitConversion:function(t,e){this.temp=JSON.parse(JSON.stringify(t)),this.dialogData.temp=this.temp,this.dialogData.tempLable=this.tempLable,this.dialogData.title="设置单位",this.openDialogName="dialogUnit",this.showDialog=!0,this.visible=!0},productPrice:function(t,e){this.temp=JSON.parse(JSON.stringify(t)),this.dialogData.temp=this.temp,this.dialogData.tempLable=this.tempLable,this.dialogData.title="设置单价",this.openDialogName="dialogPrice",this.showDialog=!0,this.visible=!0},refreshTable:function(){var t=this;t.$axios.all([Object(r.listPageProducts)(d({},t.tempQuery,{genreId:t.selectTree.id,dataType:this.$storage.get("dataType"),addColumn:{columnKey:"prodInfo",columnName:"货品"},prodColumnKey:"code,name,spec,property",fieldCode:"prodInfo,unitName,price",pageNo:t.pageNo}))]).then(t.$axios.spread(function(e){t.getListPage(e)})).catch(function(t){})}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{pageNo:function(){this.initTable(null,this.selectTree.id)}}},m=(i("LyGo"),i("KHd+")),y=Object(m.a)(b,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"saleProductPrice"},[t.searchList.length?i("search-bar",{attrs:{searchList:t.searchList,searchConfig:t.searchConfig},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),i("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:t.tableHeight+"px"}},[i("el-col",{staticClass:"treeStyle",attrs:{span:4}},[i("base-tree",{ref:"tree",attrs:{data:t.treeData,treeConfigs:t.treeConfigs},on:{treedatabridge:t.treeDataBridge}})],1),t._v(" "),i("el-col",{staticClass:"tableStyle",attrs:{span:20}},[i("div",{staticClass:"baseTable"},[t.configs.topBarBtnList&&t.configs.topBarBtnList.length?i("el-row",{staticClass:"tableTopBar"},[i("el-col",[i("div",{staticClass:"tableBtns"},[t._l(t.configs.topBarBtnList,function(t,e){return[i("base-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"item.isShow"}],attrs:{name:t.name,icon:t.icon,plain:t.plain,state:t.state,dialog:t.dialog},on:{myclick:t.method}})]})],2)])],1):t._e(),t._v(" "),i("el-row",{staticClass:"tableContent"},[i("base-table",{attrs:{data:t.tableData,colConfigs:t.configs.tableConfigs,showCheckBox:t.configs.showCheckBox,showIndex:t.configs.showIndex,pageData:t.pageData,currentpage:t.pageNo},on:{databridge:t.dataBridge,"update:currentpage":function(e){t.pageNo=e}}})],1)],1)])],1),t._v(" "),t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visible},on:{"close-dialog":t.closeDialog}}):t._e()],1)},[],!1,null,null,null);y.options.__file="index.vue";e.default=y.exports},mys0:function(t,e,i){}}]);