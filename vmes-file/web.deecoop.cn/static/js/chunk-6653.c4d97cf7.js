(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-6653"],{I3h9:function(e,t,a){"use strict";a.r(t);a("rGqo"),a("f3/d"),a("91GP");var i=a("uTIz"),s=a("WIyV"),o=a("zDZ1"),n=a("OGen"),r=a("Yo6V"),l=a("fsTK"),c=a("xMja"),d=a("5W5M"),h=(a("Vobf"),a("z0WU")),p={components:{searchBar:i.a,customBaseTable:s.a,dialogQrcode:o.a,dialogAdd:n.default,dialogEdit:r.default,dialogUnit:l.default},data:function(){return{guid:"",searchList:[{label:"货品编码",type:"input",ruleType:"string",mapKey:"code",configs:{},placeholder:"请输入货品编码"},{label:"货品名称",type:"input",ruleType:"string",mapKey:"name",configs:{},placeholder:"请输入货品名称"},{label:"规格型号",type:"input",ruleType:"string",mapKey:"spec",configs:{},placeholder:"请输入规格型号"},{label:"货品属性",type:"cascader",mapKey:"genreSelect",configs:{clearable:!0,apiName:"getDictionarys",params:{dictionaryKey:"productGenre",isglobal:"1"}},placeholder:"请选择"},{label:"自定义属性",type:"input",ruleType:"string",mapKey:"property",configs:{},placeholder:"自定义属性"},{label:"货品类型",type:"input",ruleType:"string",mapKey:"typeName",configs:{},placeholder:"请输入货品类型"}],searchConfig:{hideSearchSwitch:!1},searchObj:{},treeData:[],treeConfigs:{ref:"tree",showCheckBox:!1,showIcons:!1},selectTree:{pid:"",id:"",name:""},configs:{topBarBtnList:[{name:"新增",nameEn:"add",isShow:!0,icon:"add",method:this.addNew},{name:"删除",nameEn:"delete",isShow:!0,icon:"delete",method:this.deleteBatch},{name:"导出",nameEn:"export",isShow:!0,icon:"export",method:this.exportExcel},{name:"导入",nameEn:"import",isShow:!0,icon:"import",method:this.importExcelCallBack,dialog:{enable:!0,data:{exportUrl:"/fileUpload/excelTemplet/ProductExcelImport.xlsx",importUrl:"/base/product/importExcelProduct"},dialogName:"dialogImportExcel"}}]},tableData:[],varList:[],apiObj:{apiName:"listPageProducts",params:{fieldCode:"code,name,spec,property,genreName,unitName,typeName,validityDays,remark,isdisable",isNeedProductProperty:"true",dataType:this.$storage.get("dataType")}},customColumn:[{columnIndex:"isdisable",componentName:"switch",_cellConfig:{methodName:"switchEvent",hideTitle:!0}},{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"编辑",nameEn:"editBtns",editBtns_isShow:!0,method:this.editBtns},{name:"二维码",nameEn:"qrcodeBtns",editBtns_isShow:!0,method:this.qrcodeBtns},{name:"设置单位",nameEn:"unitConversion",editBtns_isShow:!0,method:this.unitConversion}]}],mergeTitle:[],mergeColumn:[],mergeRow:[],keyMapping:{},openDialogName:"",showDialog:!1,visible:!1,dialogData:{title:"",data:null},dialogLoading:!0,temp:{}}},beforeCreate:function(){},created:function(){this.initTree()},beforeMount:function(){},mounted:function(){},beforeUpdate:function(){},updated:function(){},methods:{getData:function(){this.$refs.productIndex.getData()},pushData:function(){this.$refs.productIndex.updateTable()},searchMap:function(e){this.searchObj=e,this.apiObj.params=Object.assign({},this.apiObj.params,this.searchObj)},sendGuid:function(e){this.guid=e},initTree:function(){var e=this;this.dialogLoading=!0,Object(d.listTreeDictionary)({dictionaryKey:"productGenre"}).then(function(t){e.loadTree(t)}).catch(function(t){e.dialogLoading=!1})},loadTree:function(e){var t=[],a=e.result.treeList;this.selectTree={pid:a.pid,id:a.id,layer:a.layer,name:a.name},t.push(a),this.treeData=t,this.dialogLoading=!1},treeDataBridge:function(e){this.selectTree={pid:e.nodeData.pid,id:e.nodeData.id,layer:e.nodeData.layer,name:e.nodeData.name},this.apiObj.params=Object.assign({},this.apiObj.params,{genreId:this.selectTree.id})},closeDialog:function(e){this.showDialog=!1,"ok"===e.resState&&(this.apiObj.params=Object.assign({},this.apiObj.params,{genreId:this.selectTree.id}))},databridge:function(e){this.tableData=e},callMethod:function(e){e&&e.methodName&&this[e.methodName](e.params)},resetTemp:function(){for(var e in this.temp)this.temp[e]=""},addNew:function(){this.resetTemp(),"4c4bd1b59954438c8bf56facd97a0c7e"!=this.selectTree.id?(this.temp.genre=this.selectTree.id,this.temp.genreName=this.selectTree.name,this.dialogData.temp=this.temp,this.dialogData.tempLable=this.tempLable,this.dialogData.title="新增",this.openDialogName="dialogAdd",this.showDialog=!0,this.visible=!0):this.$message({showClose:!0,message:"请选择正确的货品！",duration:5e3})},deleteBatch:function(){var e=this;null!=this.tableData&&0!=this.tableData.length?this.$confirm("此操作将永久删除该记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){var t="";e.tableData.forEach(function(e){t+=e.id+","}),Object(c.deleteProduct)(t).then(function(t){0===t.code&&(e.$notify({title:"成功",message:"删除成功",type:"success",duration:2e3}),e.pushData())}).catch(function(e){})}).catch(function(){e.$message({type:"info",message:"已取消删除"})}):this.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一项货品！"})},exportExcel:function(){var e="";null!=this.tableData&&this.tableData.length>0&&this.tableData.forEach(function(t){e=e+t.id+","}),Object(c.exportExcelProducts)(e).then(function(e){e&&Object(h.j)(e,"产品列表导出.xls")}).catch(function(e){})},importExcelCallBack:function(){this.apiObj.params=Object.assign({},this.apiObj.params,{genreId:this.selectTree.id})},editBtns:function(e,t){this.temp=JSON.parse(JSON.stringify(e)),this.dialogData.temp=this.temp,this.dialogData.tempLable=this.tempLable,this.dialogData.title="编辑",this.openDialogName="dialogEdit",this.showDialog=!0,this.visible=!0},qrcodeBtns:function(e,t){this.temp=JSON.parse(JSON.stringify(e)),this.dialogData.temp=this.temp,this.dialogData.tempLable={code:"货品编码",name:"货品名称"},this.dialogData.title="二维码",this.openDialogName="dialogQrcode",this.showDialog=!0,this.visible=!0},unitConversion:function(e,t){this.temp=JSON.parse(JSON.stringify(e)),this.dialogData.temp=this.temp,this.dialogData.tempLable=this.tempLable,this.dialogData.title="设置单位",this.openDialogName="dialogUnit",this.showDialog=!0,this.visible=!0},switchEvent:function(e,t){var a=this;Object(c.updateDisableProduct)(e.row.id,e.row.isdisable).then(function(t){if(0===t.code){var i="";"1"==e.row.isdisable?i="该货品已启用":"0"==e.row.isdisable&&(i="该货品已禁用"),a.$notify({title:"操作成功",message:i,type:"success",duration:5e3})}}).catch(function(t){"0"===e.row.isdisable?e.row.isdisable="1":"1"===e.row.isdisable&&(e.row.isdisable="0")})}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0},dialogName:function(){return this.openDialogName}},watch:{}},m=(a("icAp"),a("mPQF"),a("KHd+")),g=Object(m.a)(p,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"productManage"},[e.searchList.length?a("search-bar",{attrs:{searchList:e.searchList,searchConfig:e.searchConfig},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),a("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:e.tableHeight+"px"}},[a("el-col",{staticClass:"treeStyle",attrs:{span:4}},[a("base-tree",{ref:"tree",attrs:{data:e.treeData,treeConfigs:e.treeConfigs},on:{treedatabridge:e.treeDataBridge}})],1),e._v(" "),a("el-col",{staticClass:"tableStyle",attrs:{span:20}},[a("div",{staticClass:"baseTable"},[a("el-row",{staticClass:"tableTopBar"},[a("el-col",[e._l(e.configs.topBarBtnList,function(e,t){return[a("base-button",{directives:[{name:"show",rawName:"v-show",value:e.isShow,expression:"item.isShow"}],attrs:{name:e.name,icon:e.icon,plain:e.plain,state:e.state,dialog:e.dialog},on:{myclick:e.method}})]})],2)],1),e._v(" "),a("el-row",{staticClass:"tableContent"},[a("custom-base-table",{ref:"productIndex",attrs:{"data-custom-table-id":"views_base_product_index0",isSortable:!1,leftFixed:3,varList:e.varList,keyValue:!1,showIndex:!1,showTableSet:!1,showCheckBox:!0,customColumn:e.customColumn,apiObj:e.apiObj,mergeTitle:e.mergeTitle,mergeColumn:e.mergeColumn,mergeRow:e.mergeRow,componentId:"productIndex",showAll:!1,keyMapping:e.keyMapping},on:{callmethod:e.callMethod,databridge:e.databridge}})],1)],1)])],1),e._v(" "),e.showDialog?a(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.visible},on:{"close-dialog":e.closeDialog}}):e._e()],1)},[],!1,null,null,null);g.options.__file="index.vue";t.default=g.exports},WWDC:function(e,t,a){},icAp:function(e,t,a){"use strict";var i=a("WWDC");a.n(i).a},mPQF:function(e,t,a){"use strict";var i=a("vPRB");a.n(i).a},vPRB:function(e,t,a){}}]);