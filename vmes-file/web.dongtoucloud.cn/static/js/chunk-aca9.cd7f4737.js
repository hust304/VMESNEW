(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-aca9","chunk-4e57","chunk-44f4"],{"/FO0":function(t,e,i){},"/Owj":function(t,e,i){},"3DxY":function(t,e,i){},"8bQp":function(t,e,i){},"9O1b":function(t,e,i){"use strict";var a=i("/FO0");i.n(a).a},I3h9:function(t,e,i){"use strict";i.r(e);i("yt8O"),i("RW0V"),i("f3/d"),i("rGqo");var a=i("uTIz"),o=i("zDZ1"),n=i("OGen"),s=i("Yo6V"),l=i("fsTK"),r=i("mSNy"),c=i("xMja"),p=i("5W5M"),d=i("Vobf"),u=i("z0WU");function m(t){for(var e=1;e<arguments.length;e++){var i=null!=arguments[e]?arguments[e]:{},a=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(a=a.concat(Object.getOwnPropertySymbols(i).filter(function(t){return Object.getOwnPropertyDescriptor(i,t).enumerable}))),a.forEach(function(e){f(t,e,i[e])})}return t}function f(t,e,i){return e in t?Object.defineProperty(t,e,{value:i,enumerable:!0,configurable:!0,writable:!0}):t[e]=i,t}var h={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n      \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n      \t\t\t\t\t\t\t<el-button v-show="colConfig.editBtns_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.editBtns(scope.row,scope.$index)">编辑</el-button>\n      \t\t\t\t\t\t\t<el-button  v-show="colConfig.qrcodeBtns_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.qrcodeBtns(scope.row,scope.$index)">二维码</el-button>\n      \t\t\t\t\t\t\t<el-button  v-show="colConfig.unitConversion_isShow" type="text" class="btns" style="font-size: 12px;" @click="colConfig.unitConversion(scope.row,scope.$index)">设置单位</el-button>\n      \t\t\t\t\t</div>\n\n    \t\t\t\t</el-table-column>'},g={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n\t\t\t\t\t\t<div slot-scope="scope">\n    \t\t\t\t\t\t<el-switch active-value="1" inactive-value="0" v-model="scope.row.isdisable" @change="colConfig.changeState(scope.row,scope.$index)"></el-switch>\n    \t\t\t\t\t</div>\n    \t\t\t   </el-table-column>'},b={data:function(){return{guid:"",searchList:[{label:"货品编码",type:"input",mapKey:"code",configs:{},placeholder:"请输入货品编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"name",configs:{},placeholder:"请输入货品名称"},{label:"规格型号",type:"input",ruleType:"string",mapKey:"spec",configs:{},placeholder:"请输入规格型号"},{label:"货品属性",type:"input",ruleType:"string",mapKey:"genreName",configs:{},placeholder:"请输入货品属性"},{label:"货品类型",type:"input",ruleType:"string",mapKey:"typeName",configs:{},placeholder:"请输入货品类型"}],searchConfig:{hideSearchSwitch:!1},openDialogName:"",showDialog:!1,visible:!1,dialogData:{title:"",temp:null,tempLable:null},initConfigs:{tableOperates:{prop:"operate",label:"操作",enLabel:"operation",isPropName:!0,component:h,editBtns:this.editBtns,editBtns_isShow:!0,qrcodeBtns:this.qrcodeBtns,qrcodeBtns_isShow:!0,unitConversion:this.unitConversion,unitConversion_isShow:!0}},configs:{topBarBtnList:[{name:"新增",nameEn:"add",isShow:!0,icon:"add",method:this.addNew},{name:"删除",nameEn:"delete",isShow:!0,icon:"delete",plain:!0,state:!0,method:this.deleteBatch},{name:"导出",nameEn:"export",isShow:!0,icon:"export",method:this.exportExcel},{name:"导入",nameEn:"import",isShow:!0,icon:"import",method:this.importExcelCallBack,dialog:{enable:!0,data:{exportUrl:"/fileUpload/excelTemplet/ProductExcelImport.xlsx",importUrl:"/base/product/importExcelProduct"},dialogName:"dialogImportExcel"}}],tableConfigs:[],showCheckBox:!1,showIndex:!1},treeData:[],treeConfigs:{ref:"tree",showCheckBox:!1,showIcons:!1},selectTree:{pid:"",id:"",name:""},tableData:[],selectList:null,temp:{},tempQuery:{},tempLable:{},pageData:null,pageNo:1}},components:{searchBar:a.a,dialogAdd:n.default,dialogEdit:s.default,dialogQrcode:o.a,dialogUnit:l.default},beforeCreate:function(){},created:function(){this.initButtons(),this.initTree()},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{searchMap:function(t){this.tempQuery=t,this.pageNo=1,this.initTable(null,this.selectTree.id)},sendGuid:function(t){this.guid=t},closeDialog:function(t){this.showDialog=!1,"ok"===t.resState&&this.refreshTable()},initButtons:function(){var t=this,e=t.$storage.get("userInfo").roleIds,i=t.$storage.get("menuId");e&&(t.$loading({spinner:"none",text:"云上企业"}),Object(d.initMenuButtons)({menuId:i,roleId:e}).then(function(e){var i=e.buttonList;i&&i.forEach(function(e){if(t.initConfigs&&t.initConfigs.tableOperates)for(var i in t.initConfigs.tableOperates)i.indexOf(e.nameEn)>=0&&i.indexOf("isShow")>0&&(t.initConfigs.tableOperates[i]=!1);if(t.customColumn)for(var a in t.customColumn)if(a){var o=t.customColumn[a];o.length>0&&o.forEach(function(t){if(t)for(var i in t)i.indexOf(e.nameEn)>=0&&i.indexOf("isShow")>0&&(t[i]=!1)})}t.configs&&(t.configs.queryBarBtnList&&t.configs.queryBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(t.isShow=!1)}),t.configs.topBarBtnList&&t.configs.topBarBtnList.forEach(function(t){t.nameEn==e.nameEn&&(console.log(t),t.isShow=!1)}))})}).catch(function(e){console.log(e),t.$loading().close()}))},initTree:function(){var t=this;Object(p.listTreeDictionary)({dictionaryKey:"productGenre"}).then(function(e){var i=[],a=e.result.treeList;t.selectTree={pid:a.pid,id:a.id,layer:a.layer,name:a.name},i.push(a),t.treeData=i,t.initTable(!0,t.selectTree.id),t.$nextTick(function(){t.$refs.tree.$children[0].setCurrentKey(t.selectTree.id)})}).catch(function(e){t.$loading().close()})},treeDataBridge:function(t){this.selectTree={pid:t.nodeData.pid,id:t.nodeData.id,layer:t.nodeData.layer,name:t.nodeData.name},this.pageNo=1,this.initTable(null,this.selectTree.id)},initTable:function(t,e){var i=this;Object(c.listPageProducts)(m({},i.tempQuery,{genreId:e,pageNo:i.pageNo})).then(function(e){i.getListPage(e),t&&i.$loading().close()}).catch(function(t){i.$loading().close()})},getListPage:function(t){if(t){this.pageData=t.result.pageData,this.initTempData(t.result.titles);var e=Object(u.l)(t.result),i=this.addTableTitle(e);this.configs.tableConfigs=i,this.configs.showCheckBox=!0,this.configs.showIndex=!0,this.tableData=t.result.varList,this.configs.topBarBtnList.forEach(function(t){"delete"==t.nameEn&&(t.state=!0)})}},initTempData:function(t){var e=this;t.forEach(function(t){for(var i in t){var a=t[i];a.indexOf("_")>0&&("en"==r.a.locale?a=a.substring(a.indexOf("_")+1):"zh"==r.a.locale&&(a=a.substring(0,a.indexOf("_")))),e.tempLable[i]=a}}),console.log(e.tempLable)},addTableTitle:function(t){var e=this;return t.forEach(function(t){var i=t.label;i.indexOf("_")>0&&("en"==r.a.locale?t.label=i.substring(i.indexOf("_")+1):"zh"==r.a.locale&&(t.label=i.substring(0,i.indexOf("_")))),"是否启用"===t.label&&(t.component=g,t.changeState=e.changeState)}),e.internationalConfig(),t.push(e.initConfigs.tableOperates),t},internationalConfig:function(){"en"==r.a.locale?this.initConfigs.tableOperates.label="OPERATE":"zh"==r.a.locale&&(this.initConfigs.tableOperates.label="操作")},changeState:function(t,e){Object(c.updateDisableProduct)(t.id,t.isdisable).then(function(t){}).catch(function(t){})},dataBridge:function(t){this.selectList=t,t.length?this.configs.topBarBtnList.forEach(function(t){"delete"==t.nameEn&&(t.state=!1)}):this.configs.topBarBtnList.forEach(function(t){"delete"==t.nameEn&&(t.state=!0)})},unitConversion:function(t,e){this.resetTemp(),this.temp=JSON.parse(JSON.stringify(t)),this.dialogData.temp=this.temp,this.dialogData.tempLable=this.tempLable,this.dialogData.title="设置单位",this.openDialogName="dialogUnit",this.showDialog=!0,this.visible=!0},editBtns:function(t,e){this.resetTemp(),this.temp=JSON.parse(JSON.stringify(t)),this.dialogData.temp=this.temp,this.dialogData.tempLable=this.tempLable,this.dialogData.title="编辑",this.openDialogName="dialogEdit",this.showDialog=!0,this.visible=!0},qrcodeBtns:function(t,e){this.resetTemp(),this.temp=JSON.parse(JSON.stringify(t)),this.dialogData.temp=this.temp,this.dialogData.tempLable=this.tempLable,this.dialogData.title="二维码",this.openDialogName="dialogQrcode",this.showDialog=!0,this.visible=!0},addNew:function(){this.resetTemp(),"4c4bd1b59954438c8bf56facd97a0c7e"!=this.selectTree.id?(this.temp.genre=this.selectTree.id,this.temp.genreName=this.selectTree.name,this.dialogData.temp=this.temp,this.dialogData.tempLable=this.tempLable,this.dialogData.title="新增",this.openDialogName="dialogAdd",this.showDialog=!0,this.visible=!0):this.$message({showClose:!0,message:"请选择正确的货品！",duration:5e3})},resetTemp:function(){for(var t in this.temp)this.temp[t]=""},deleteBatch:function(){var t=this;t.$confirm("此操作将永久删除该记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){var e="";t.selectList.forEach(function(t){e+=t.id+","}),Object(c.deleteProduct)(e).then(function(e){0===e.code&&(t.$notify({title:"成功",message:"删除成功",type:"success",duration:2e3}),t.refreshTable())}).catch(function(t){})}).catch(function(){t.$message({type:"info",message:"已取消删除"})})},refreshTable:function(){var t=this;t.$axios.all([Object(c.listPageProducts)(m({},t.tempQuery,{genreId:t.selectTree.id,pageNo:t.pageNo}))]).then(t.$axios.spread(function(e){t.getListPage(e)})).catch(function(t){console.log(t)})},exportExcel:function(){var t="",e=this;null!=e.selectList&&e.selectList.length>0&&e.selectList.forEach(function(e){t=t+e.id+","}),Object(c.exportExcelProducts)(t).then(function(t){t&&(Object(u.g)(t,"产品列表导出.xls"),e.$message({title:"成功",message:"导出成功",type:"success",duration:2e3}))}).catch(function(t){console.log(t)})},importExcelCallBack:function(){this.refreshTable()}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{pageNo:function(){this.initTable(null,this.selectTree.id)}}},y=(i("icAp"),i("KHd+")),v=Object(y.a)(b,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"productManage"},[t.searchList.length?i("search-bar",{attrs:{searchList:t.searchList,searchConfig:t.searchConfig},on:{"search-map":t.searchMap,"send-guid":t.sendGuid}}):t._e(),t._v(" "),i("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:t.tableHeight+"px"}},[i("el-col",{staticClass:"treeStyle",attrs:{span:4}},[i("base-tree",{ref:"tree",attrs:{data:t.treeData,treeConfigs:t.treeConfigs},on:{treedatabridge:t.treeDataBridge}})],1),t._v(" "),i("el-col",{staticClass:"tableStyle",attrs:{span:20}},[i("div",{staticClass:"baseTable"},[i("el-row",{staticClass:"tableTopBar"},[i("el-col",[i("div",{staticClass:"tableBtns"},[t._l(t.configs.topBarBtnList,function(t,e){return[i("base-button",{directives:[{name:"show",rawName:"v-show",value:t.isShow,expression:"item.isShow"}],attrs:{name:t.name,icon:t.icon,plain:t.plain,state:t.state,dialog:t.dialog},on:{myclick:t.method}})]})],2)])],1),t._v(" "),i("el-row",{staticClass:"tableContent"},[i("base-table",{attrs:{data:t.tableData,colConfigs:t.configs.tableConfigs,showCheckBox:t.configs.showCheckBox,showIndex:t.configs.showIndex,pageData:t.pageData,currentpage:t.pageNo,isSortable:!1},on:{databridge:t.dataBridge,"update:currentpage":function(e){t.pageNo=e}}})],1)],1)])],1),t._v(" "),t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.visible},on:{"close-dialog":t.closeDialog}}):t._e()],1)},[],!1,null,null,null);v.options.__file="index.vue";e.default=v.exports},JqKq:function(t,e,i){},NaOS:function(t,e,i){"use strict";i("rGqo");function a(t,e,i){return e in t?Object.defineProperty(t,e,{value:i,enumerable:!0,configurable:!0,writable:!0}):t[e]=i,t}var o={components:{},name:"dyna-form",props:{config:{type:Object,default:function(){return{}}},formTemp:{type:Array,default:function(){return[]}},props:{type:Object,default:function(){return{key:"key",value:"value"}}}},data:function(){var t=this;return{btnsBoxHeight:0,addFormData:[],isVisible:!1,saveBtnState:!0,tempFormList:[{key:"",value:""}],itemRule:[{validator:function(e,i,a){""===i?(t.saveBtnState=!0,a(new Error("请定义属性名称"))):t.deDuplication(i)?(t.saveBtnState=!0,a(new Error("有重复的属性名称"))):a()},trigger:"blur"}],formData:[]}},created:function(){this.formData=this.renameAttr(this.formTemp,!0)},mounted:function(){this.$nextTick(function(){this.btnsBoxHeight=this.hideBtn?this.$refs.btnsBox.clientHeight:0})},computed:{hideBtn:function(){return!this.config.hideBtn},formList:function(){return this.formData.concat(this.addFormData)},onModal:function(){return!1},onEscape:function(){return!1}},methods:{renameAttr:function(t,e){if("key"===this.props.key&&"value"===this.props.value)return t;var i=this.props,o=i.key,n=i.value,s=[];return e?(t.forEach(function(t,e){s.push({key:t[o||"key"],value:t[n||"value"]})}),s):(this.formList.forEach(function(t,e){var i;s.push((a(i={},o||"key",t.key),a(i,n||"value",t.value),i))}),s)},addAttr:function(){this.tempFormList=[{key:"",value:""}],this.isVisible=!0},removeDomain:function(t,e){var i=this,a=!0;this.formData.forEach(function(e,o){e.key===t.key&&(a=!1,i.formData.splice(o,1))}),a&&this.addFormData.forEach(function(e,a){e.key===t.key&&i.addFormData.splice(a,1)})},dialogOpen:function(){var t=this;this.saveBtnState=!0,this.$nextTick(function(){t.tempFormList.forEach(function(e,i){t.$refs["tempForm"+i][0].clearValidate()})})},getFormList:function(){this.$emit("sent-list",this.renameAttr(this.formList))},save:function(){this.addFormData=this.addFormData.concat(this.tempFormList),this.isVisible=!1},addContent:function(){this.tempFormList.push({key:"",value:""}),this.saveBtnState=!0},deleteContent:function(t,e){this.tempFormList.splice(e,1),this.switchSaveBtnState()},deDuplication:function(t){var e=0;return this.tempFormList.forEach(function(i){i.key===t&&e++}),this.formList.forEach(function(i){i.key===t&&e++}),1!==e},checkInput:function(){this.switchSaveBtnState()},switchSaveBtnState:function(){var t=this;this.$nextTick(function(){var e=0,i=!0;t.tempFormList.forEach(function(a,o){i?t.$refs["tempForm"+o][0].validate(function(t){t||(e++,i=!1)}):t.$refs["tempForm"+o][0].validate(function(t){})}),t.saveBtnState=!t.tempFormList.length||!!e})}}},n=(i("9O1b"),i("KHd+")),s=Object(n.a)(o,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"dynaForm",staticStyle:{height:"100%",position:"relative","box-sizing":"border-box"},style:{paddingTop:t.btnsBoxHeight+"px"}},[t.hideBtn?i("div",{ref:"btnsBox",staticClass:"dynaFormBtn",staticStyle:{position:"absolute",top:"0",right:"0"}},[i("el-button",{attrs:{type:"text",size:"mini",icon:"el-icon-plus"},on:{click:t.addAttr}},[t._v("自定义属性")])],1):t._e(),t._v(" "),i("div",{staticClass:"formBox",staticStyle:{height:"100%","overflow-y":"auto"}},[i("el-form",{ref:"resultForm",staticStyle:{padding:"5px"},attrs:{"label-position":"left","label-width":"75px"}},t._l(t.formList,function(e,a){return i("el-form-item",{key:e.key,attrs:{label:e.key}},[i("el-input",{staticStyle:{width:"calc(100% - 27px)"},attrs:{placeholder:"请输入",clearable:""},model:{value:e.value,callback:function(i){t.$set(e,"value",i)},expression:"item.value"}}),i("el-button",{staticStyle:{padding:"5px"},attrs:{type:"text",icon:"el-icon-remove",title:"删除该项"},on:{click:function(i){i.preventDefault(),t.removeDomain(e,a)}}})],1)}),1)],1),t._v(" "),i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:"自定义属性",visible:t.isVisible,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,width:"400px","append-to-body":""},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen}},[i("div",{staticClass:"addContent",staticStyle:{"box-sizing":"border-box",padding:"5px 10px"}},[i("div",[t._l(t.tempFormList,function(e,a){return[i("el-row",{staticStyle:{position:"relative",border:"1px solid #E4E4E4","border-radius":"4px","margin-bottom":"10px"}},[i("el-form",{ref:"tempForm"+a,refInFor:!0,staticStyle:{width:"90%",padding:"5px"},attrs:{model:e,"label-position":"left","label-width":"75px"}},[i("el-form-item",{staticStyle:{"margin-bottom":"20px"},attrs:{label:"属性名称:",prop:"key",rules:t.itemRule}},[i("el-input",{attrs:{placeholder:"请输入属性名",clearable:""},on:{blur:function(i){t.checkInput(e,a)}},model:{value:e.key,callback:function(i){t.$set(e,"key",i)},expression:"item.key"}})],1),t._v(" "),i("el-form-item",{staticStyle:{"margin-bottom":"0"},attrs:{label:"属性值:"}},[i("el-input",{attrs:{placeholder:"请输入属性值",clearable:""},model:{value:e.value,callback:function(i){t.$set(e,"value",i)},expression:"item.value"}})],1)],1),t._v(" "),i("div",{staticStyle:{position:"absolute",right:"8px",top:"50%",transform:"translate(0,-50%)"}},[i("el-button",{staticStyle:{padding:"5px"},attrs:{type:"text",icon:"el-icon-remove",title:"删除该项"},on:{click:function(i){t.deleteContent(e,a)}}})],1)],1)]})],2),t._v(" "),i("div",{ref:"dialogBtn",staticStyle:{"text-align":"center"}},[i("el-button",{staticStyle:{padding:"5px",width:"100%",border:"1px dashed #E4E4E4"},attrs:{type:"text",size:"medium",icon:"el-icon-plus"},on:{click:t.addContent}},[t._v("新增属性")])],1)]),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary",disabled:t.saveBtnState},on:{click:t.save}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)])],1)},[],!1,null,null,null);s.options.__file="index.vue";e.a=s.exports},OGen:function(t,e,i){"use strict";i.r(e);i("rE2o"),i("ioFf"),i("pIFo"),i("Oyvg"),i("xfY5");var a=i("xMja");function o(t){return(o="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var n={components:{DynaForm:i("NaOS").a},name:"dialog-add",props:["initData","visible"],data:function(){var t=this;return{dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{},rules:{name:[{required:!0,message:"请填写货品名称",trigger:"change"}],spec:[{required:!0,message:"请填写规格型号",trigger:"change"}],unitName:[{required:!0,trigger:"change",validator:function(e,i,a){t.unitData.defaultSelected.length<=0?a(new Error("请选择计量单位")):a()}}]},actionUrl:"",imageUrl:"",fileData:{photoDir:"product/"},unitData:{data:{selectUrl:"/system/dictionary/getDictionarys",selectParm:{dictionaryKey:"productUnit",isglobal:"0"}},defaultSelected:[]},lastUnitData:{data:{selectUrl:"/system/dictionary/getDictionarys",selectParm:{dictionaryKey:"productUnit",isglobal:"0"}},defaultSelected:[]},productTypeData:{data:{selectUrl:"/system/dictionary/getDictionarys",selectParm:{dictionaryKey:"productType",isglobal:"0"}},defaultSelected:[]},openDialogName:"",showDialog:!1,inLinVisible:!1,formTemp:[]}},created:function(){this.initData.temp&&(this.temp=this.initData.temp,this.temp.validityDays&&(this.temp.validityDays=Number(this.temp.validityDays)),this.temp.validityDays=0),this.initData.tempLable&&(this.tempLable=this.initData.tempLable)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=o(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{unitSelect:function(t){t[0]?(this.temp.unit=t[0],this.unitData.defaultSelected=[t[0]]):(this.temp.unit=[],this.unitData.defaultSelected=[])},lastUnitSelect:function(t){t[0]?(this.temp.lastUnit=t[0],this.lastUnitData.defaultSelected=[t[0]]):(this.temp.lastUnit=[],this.lastUnitData.defaultSelected=[])},productTypeSelect:function(t){t[0]?(this.temp.type=t[0],this.productTypeData.defaultSelected=[t[0]]):(this.temp.type=[],this.productTypeData.defaultSelected=[])},checkPrice:function(t){new RegExp("^[0-9]+\\.{0,1}[0-9]{0,2}$").test(t)||this.$message({message:"单价:"+t+" 输入错误，请输入大于零的正整数或(1,2)位小数！",type:"warning",duration:5e3})},dialogOpen:function(){var t=this;this.imageUrl="",this.actionUrl="https://web.ouhaicloud.com//fileIO/file/uploadPhoto",this.temp.unit=this.unitData.defaultSelected[0],this.temp.lastUnit=this.lastUnitData.defaultSelected[0],this.temp.type=this.productTypeData.defaultSelected[0],this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},formListResult:function(t){var e="";null!=t&&t.length>0&&(e=JSON.stringify(t)),this.temp.prodPropertyJsonStr=e},save:function(){var t=this;this.$refs.dynaForm.getFormList(),this.$refs.submitForm.validate(function(e){e&&(t.dialogLoading=!0,Object(a.addProduct)(t.temp).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){t.dialogLoading=!1}))})},handleAvatarSuccess:function(t){if(0==t.code){var e=t.photo;null!=e&&e.trim().length>0&&(this.temp.photo=e,this.imageUrl="https://web.ouhaicloud.com/"+e),this.$message({message:"图片上传成功！",type:"success",duration:5e3})}else 0!=t.code&&null!=t.msg&&t.msg.trim().length>0&&this.$message.error(t.msg.trim())},beforeAvatarUpload:function(t){var e=t.type;if(e=e.replace("image/",""),-1!="jpg,jpeg,png".indexOf(e)){t.size>5242880&&this.$message({message:"上传员工照片大小不能超过 5MB!",type:"error",duration:5e3})}else this.$message({message:"上传员工照片只能是(jpg,jpeg,png)格式文件!",type:"error",duration:5e3})},closeDialog:function(t){this.showDialog=!1}}},s=(i("nmHX"),i("uZyO"),i("KHd+")),l=Object(s.a)(n,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],staticStyle:{height:"90vh"},attrs:{title:t.initData.title?t.initData.title:"新增",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"620px",top:"10vh","custom-class":"listDeliverClass"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[t.showDialog?i(t.dialogName,{tag:"component",attrs:{initData:t.dialogData,visible:t.inLinVisible},on:{"close-dialog":t.closeDialog}}):t._e(),t._v(" "),i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}],staticStyle:{height:"100%",overflow:"auto"}},[i("el-form",{ref:"submitForm",staticStyle:{width:"570px","padding-top":"10px"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[i("el-row",[i("el-col",{staticStyle:{"padding-left":"150px"},attrs:{span:12}},[i("el-upload",{staticClass:"avatar-uploader",attrs:{name:"fileName",action:t.actionUrl,data:t.fileData,"show-file-list":!1,"on-success":t.handleAvatarSuccess,"before-upload":t.beforeAvatarUpload}},[t.imageUrl?i("img",{staticClass:"avatar",attrs:{src:t.imageUrl}}):i("i",{staticClass:"el-icon-plus avatar-uploader-icon"})])],1),t._v(" "),i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:t.tempLable.genreName+":",prop:"genreName"}},[i("el-input",{attrs:{disabled:!0},model:{value:t.temp.genreName,callback:function(e){t.$set(t.temp,"genreName",e)},expression:"temp.genreName"}})],1),t._v(" "),i("el-form-item",{attrs:{label:t.tempLable.name+":",prop:"name"}},[i("el-input",{model:{value:t.temp.name,callback:function(e){t.$set(t.temp,"name",e)},expression:"temp.name"}})],1)],1)],1),t._v(" "),i("el-row",[i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:t.tempLable.sourceCode+":",prop:"sourceCode"}},[i("el-input",{model:{value:t.temp.sourceCode,callback:function(e){t.$set(t.temp,"sourceCode",e)},expression:"temp.sourceCode"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:t.tempLable.pictureCode+":",prop:"validityDays"}},[i("el-input",{model:{value:t.temp.pictureCode,callback:function(e){t.$set(t.temp,"pictureCode",t._n(e))},expression:"temp.pictureCode"}})],1)],1)],1),t._v(" "),i("el-row",[i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:t.tempLable.spec+":",prop:"spec"}},[i("el-input",{model:{value:t.temp.spec,callback:function(e){t.$set(t.temp,"spec",e)},expression:"temp.spec"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:t.tempLable.unitName+":",prop:"unitName"}},[i("base-input-select",{attrs:{data:t.unitData.data},on:{callback:t.unitSelect},model:{value:t.unitData.defaultSelected,callback:function(e){t.$set(t.unitData,"defaultSelected",e)},expression:"unitData.defaultSelected"}})],1)],1)],1),t._v(" "),i("el-row",[i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:t.tempLable.validityDays+":",prop:"validityDays"}},[i("el-input",{model:{value:t.temp.validityDays,callback:function(e){t.$set(t.temp,"validityDays",t._n(e))},expression:"temp.validityDays"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:t.tempLable.typeName+":",prop:"typeName"}},[i("base-input-select",{attrs:{data:t.productTypeData.data},on:{callback:t.productTypeSelect},model:{value:t.productTypeData.defaultSelected,callback:function(e){t.$set(t.productTypeData,"defaultSelected",e)},expression:"productTypeData.defaultSelected"}})],1)],1)],1),t._v(" "),i("el-row",[i("el-col",{attrs:{span:24}},[i("el-form-item",{attrs:{label:t.tempLable.remark+":",prop:"remark"}},[i("el-input",{staticStyle:{width:"450px"},attrs:{type:"textarea",rows:"2"},model:{value:t.temp.remark,callback:function(e){t.$set(t.temp,"remark",e)},expression:"temp.remark"}})],1)],1)],1),t._v(" "),i("el-row",[i("div",{staticStyle:{height:"200px"}},[i("dyna-form",{ref:"dynaForm",attrs:{formTemp:t.formTemp,props:{key:"name",value:"value"}},on:{"sent-list":t.formListResult}})],1)])],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)],1)},[],!1,null,"9ab96328",null);l.options.__file="dialogAdd.vue";e.default=l.exports},VfKu:function(t,e,i){"use strict";var a=i("/Owj");i.n(a).a},Yo6V:function(t,e,i){"use strict";i.r(e);i("rE2o"),i("ioFf"),i("pIFo"),i("Oyvg");var a=i("xMja");function o(t){return(o="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var n={components:{DynaForm:i("NaOS").a},name:"dialog-edit",props:["initData","visible"],data:function(){var t=this;return{dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{},rules:{name:[{required:!0,message:"请填写货品名称",trigger:"change"}],spec:[{required:!0,message:"请填写规格型号",trigger:"change"}],unitName:[{required:!0,trigger:"change",validator:function(e,i,a){t.unitData.defaultSelected.length<=0?a(new Error("请选择计量单位")):a()}}],validityDays:[{type:"number",trigger:"change",validator:function(t,e,i){e<0?i(new Error("保质期必须大于零")):i()}}]},actionUrl:"",imageUrl:"",fileData:{photoDir:"product/"},unitData:{data:{selectUrl:"/system/dictionary/getDictionarys",selectParm:{dictionaryKey:"productUnit",isglobal:"0"}},defaultSelected:[]},lastUnitData:{data:{selectUrl:"/system/dictionary/getDictionarys",selectParm:{dictionaryKey:"productUnit",isglobal:"0"}},defaultSelected:[]},productTypeData:{data:{selectUrl:"/system/dictionary/getDictionarys",selectParm:{dictionaryKey:"productType",isglobal:"0"}},defaultSelected:[]},formTemp:[]}},created:function(){this.initData.temp&&(this.temp=this.initData.temp,this.temp.validityDays||(this.temp.validityDays=0)),this.initData.tempLable&&(this.tempLable=this.initData.tempLable),this.temp.photo?this.imageUrl="https://web.ouhaicloud.com/"+this.temp.photo:this.imageUrl=""},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=o(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]}},methods:{unitSelect:function(t){this.temp.unit=t[0]},lastUnitSelect:function(t){this.temp.lastUnit=t[0]},productTypeSelect:function(t){this.temp.type=t[0]},checkPrice:function(t){new RegExp("^[0-9]+\\.{0,1}[0-9]{0,2}$").test(t)||this.$message({message:"单价:"+t+" 输入错误，请输入大于零的正整数或(1,2)位小数！",type:"warning",duration:5e3})},dialogOpen:function(){var t=this;this.actionUrl="https://web.ouhaicloud.com//fileIO/file/uploadPhoto",this.unitData.defaultSelected=[],this.unitData.defaultSelected.push(this.temp.unit),this.lastUnitData.defaultSelected=[],this.lastUnitData.defaultSelected.push(this.temp.lastUnit),this.productTypeData.defaultSelected=[],this.productTypeData.defaultSelected.push(this.temp.type);var e=this.temp.prodPropertyJsonStr;null!=e&&e.trim().length>0&&(this.formTemp=JSON.parse(e)),this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},formListResult:function(t){var e="";null!=t&&t.length>0&&(e=JSON.stringify(t)),this.temp.prodProperty=e},save:function(){var t=this;this.$refs.dynaForm.getFormList(),t.$refs.submitForm.validate(function(e){e&&(t.dialogLoading=!0,Object(a.updateProduct)(t.temp).then(function(e){t.dialogLoading=!1,0===e.code&&(t.$notify({title:"成功",message:"修改成功",type:"success",duration:2e3}),t.isVisible=!1,t.dialogClose({resState:"ok"}))}).catch(function(e){console.log(e),t.dialogLoading=!1}))})},handleAvatarSuccess:function(t){if(0==t.code){var e=t.photo;null!=e&&e.trim().length>0&&(this.temp.photo=e,this.imageUrl="https://web.ouhaicloud.com/"+e),this.$message({message:"图片上传成功！",type:"success",duration:5e3})}else 0!=t.code&&null!=t.msg&&t.msg.trim().length>0&&this.$message.error(t.msg.trim())},beforeAvatarUpload:function(t){var e=t.type;if(e=e.replace("image/",""),-1!="jpg,jpeg,png".indexOf(e)){t.size>5242880&&this.$message({message:"上传员工照片大小不能超过 5MB!",type:"error",duration:5e3})}else this.$message({message:"上传员工照片只能是(jpg,jpeg,png)格式文件!",type:"error",duration:5e3})}}},s=(i("apiY"),i("wWhO"),i("KHd+")),l=Object(s.a)(n,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],staticStyle:{height:"90vh"},attrs:{title:t.initData.title?t.initData.title:"编辑",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"620px",top:"10vh","custom-class":"listDeliverClass"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}],staticStyle:{height:"100%",overflow:"auto"}},[i("el-form",{ref:"submitForm",staticStyle:{width:"570px","padding-top":"10px"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[i("el-row",[i("el-col",{staticStyle:{"padding-left":"150px"},attrs:{span:12}},[i("el-upload",{staticClass:"avatar-uploader",attrs:{name:"fileName",action:t.actionUrl,data:t.fileData,"show-file-list":!1,"on-success":t.handleAvatarSuccess,"before-upload":t.beforeAvatarUpload}},[t.imageUrl?i("img",{staticClass:"avatar",attrs:{src:t.imageUrl}}):i("i",{staticClass:"el-icon-plus avatar-uploader-icon"})])],1),t._v(" "),i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:t.tempLable.sysCode+":",prop:"code"}},[i("el-input",{attrs:{disabled:!0},model:{value:t.temp.sysCode,callback:function(e){t.$set(t.temp,"sysCode",e)},expression:"temp.sysCode"}})],1),t._v(" "),i("el-form-item",{attrs:{label:t.tempLable.name+":",prop:"name"}},[i("el-input",{model:{value:t.temp.name,callback:function(e){t.$set(t.temp,"name",e)},expression:"temp.name"}})],1)],1)],1),t._v(" "),i("el-row",[i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:t.tempLable.sourceCode+":",prop:"sourceCode"}},[i("el-input",{model:{value:t.temp.sourceCode,callback:function(e){t.$set(t.temp,"sourceCode",e)},expression:"temp.sourceCode"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:t.tempLable.pictureCode+":",prop:"validityDays"}},[i("el-input",{model:{value:t.temp.pictureCode,callback:function(e){t.$set(t.temp,"pictureCode",t._n(e))},expression:"temp.pictureCode"}})],1)],1)],1),t._v(" "),i("el-row",[i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:t.tempLable.spec+":",prop:"spec"}},[i("el-input",{model:{value:t.temp.spec,callback:function(e){t.$set(t.temp,"spec",e)},expression:"temp.spec"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:t.tempLable.typeName+":",prop:"typeName"}},[i("base-input-select",{attrs:{data:t.productTypeData.data},on:{callback:t.productTypeSelect},model:{value:t.productTypeData.defaultSelected,callback:function(e){t.$set(t.productTypeData,"defaultSelected",e)},expression:"productTypeData.defaultSelected"}})],1)],1)],1),t._v(" "),i("el-row",[i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:t.tempLable.stockCount+":",prop:"stockCount"}},[i("el-input",{attrs:{disabled:!0},model:{value:t.temp.stockCount,callback:function(e){t.$set(t.temp,"stockCount",e)},expression:"temp.stockCount"}})],1)],1),t._v(" "),i("el-col",{attrs:{span:12}},[i("el-form-item",{attrs:{label:t.tempLable.validityDays+":",prop:"validityDays"}},[i("el-input",{model:{value:t.temp.validityDays,callback:function(e){t.$set(t.temp,"validityDays",t._n(e))},expression:"temp.validityDays"}})],1)],1)],1),t._v(" "),i("el-row",[i("el-col",{attrs:{span:24}},[i("el-form-item",{attrs:{label:t.tempLable.remark+":",prop:"remark"}},[i("el-input",{staticStyle:{width:"450px"},attrs:{type:"textarea",rows:"2"},model:{value:t.temp.remark,callback:function(e){t.$set(t.temp,"remark",e)},expression:"temp.remark"}})],1)],1)],1),t._v(" "),i("el-row",[i("div",{staticStyle:{height:"200px"}},[i("dyna-form",{ref:"dynaForm",attrs:{formTemp:t.formTemp,props:{key:"name",value:"value"}},on:{"sent-list":t.formListResult}})],1)])],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("保存")]),t._v(" "),i("el-button",{on:{click:function(e){t.isVisible=!1}}},[t._v("关闭")])],1)],1)])},[],!1,null,"52580914",null);l.options.__file="dialogEdit.vue";e.default=l.exports},apiY:function(t,e,i){"use strict";var a=i("wuKC");i.n(a).a},brR2:function(t,e,i){},icAp:function(t,e,i){"use strict";var a=i("brR2");i.n(a).a},lZYi:function(t,e,i){"use strict";var a=i("wnxv");i.n(a).a},nmHX:function(t,e,i){"use strict";var a=i("3DxY");i.n(a).a},uZyO:function(t,e,i){"use strict";var a=i("JqKq");i.n(a).a},wWhO:function(t,e,i){"use strict";var a=i("8bQp");i.n(a).a},wnxv:function(t,e,i){},wuKC:function(t,e,i){},zDZ1:function(t,e,i){"use strict";i("rE2o"),i("ioFf"),i("f3/d"),i("9WTv");function a(t){return(a="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t})(t)}var o={name:"dialog-add",props:["initData","visible"],components:{},data:function(){return{dialogLoading:!0,isVisible:!1,inDialog:!0,temp:{},tempLable:{},tempNotEditable:{},tempShow:{},rules:{},imageUrl:""}},created:function(){console.log(this.initData),this.initData.temp&&(this.temp=this.initData.temp,this.initData.temp.qrcode&&(this.imageUrl="https://web.ouhaicloud.com/"+this.initData.temp.qrcode)),this.initData.tempLable&&(this.tempLable=this.initData.tempLable)},mounted:function(){this.dialogLoading=!1,this.isVisible=this.visible},computed:{dialogWidth:function(){if(this.initData.width){var t=a(this.initData.width);if("number"===t)return this.initData.width+"px";if("string"===t){var e=parseInt(this.initData.width);return e?e>100?"100%":e+"%":"300px"}return"300px"}return"300px"},fullscreen:function(){return!!this.initData.fullscreen},onModal:function(){return!!this.initData["close-on-click-modal"]},onEscape:function(){return!!this.initData["close-on-press-escape"]},dialogName:function(){return this.openDialogName}},methods:{dialogOpen:function(){var t=this;this.$nextTick(function(){t.$refs.submitForm.clearValidate()})},dialogClose:function(t){this.$emit("close-dialog",t||{})},download:function(){var t=this.imageUrl,e=document.createElement("a");e.style.display="none",e.href=t,e.setAttribute("download",this.temp.name),document.body.appendChild(e),e.click()},print:function(){var t='<!DOCTYPE html> <html> <head> <meta charset="utf-8"> <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> ';t+="<style></style>",t+="</head><body >",t+=document.getElementById("printContent").innerHTML,t+="</body></html>";var e=window.open("","打印","");e.document.write(t),e.document.close(),e.focus(),e.print(),e.close()},dialogImgLoad:function(){this.$refs.myDialog&&this.$refs.myDialog.reDialogStyle&&this.$refs.myDialog.reDialogStyle(this.$store.getters.systemInfo,!0)}}},n=(i("lZYi"),i("VfKu"),i("KHd+")),s=Object(n.a)(o,function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],ref:"myDialog",attrs:{title:t.initData.title?t.initData.title:"二维码",visible:t.isVisible,"append-to-body":t.inDialog,"close-on-click-modal":t.onModal,"close-on-press-escape":t.onEscape,fullscreen:t.fullscreen,width:"400px"},on:{"update:visible":function(e){t.isVisible=e},open:t.dialogOpen,close:t.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:t.dialogLoading,expression:"dialogLoading"}],staticStyle:{"padding-top":"10px"}},[i("div",{attrs:{id:"printContent"}},[i("el-form",{ref:"submitForm",staticStyle:{width:"400px",margin:"10px auto"},attrs:{rules:t.rules,model:t.temp,"label-position":"right","label-width":"120px"}},[i("el-row",[i("el-col",{staticStyle:{"text-align":"center","padding-bottom":"20px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},attrs:{span:24}},[t.imageUrl?i("img",{staticClass:"avatar",staticStyle:{margin:"0 auto"},attrs:{src:t.imageUrl},on:{load:t.dialogImgLoad}}):i("i",{staticClass:"el-icon-plus avatar-uploader-icon"})])],1),t._v(" "),i("el-row",[i("el-col",{attrs:{span:24}},[i("b",{staticStyle:{"padding-left":"35%"}},[t._v(t._s(t.tempLable.code)+":")]),t._v(t._s(t.temp.code)),i("br"),t._v(" "),i("b",{staticStyle:{"padding-left":"35%"}},[t._v(t._s(t.tempLable.name)+":")]),t._v(t._s(t.temp.name)+"\n\n          ")])],1)],1)],1),t._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center",padding:"15px 0 15px 0"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.download}},[t._v("下载")]),t._v(" "),i("el-button",{attrs:{type:"primary"},on:{click:t.print}},[t._v("打印")])],1)])])},[],!1,null,"20580914",null);s.options.__file="dialogQrcode.vue";e.a=s.exports}}]);