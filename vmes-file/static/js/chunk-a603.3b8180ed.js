(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-a603"],{"5NjW":function(e,t,a){},EjHx:function(e,t,a){"use strict";a.r(t);a("yt8O"),a("RW0V"),a("rGqo");var i=a("mSNy"),n=a("uTIz"),o=a("/Kw/"),l=a("Vobf"),s=(a("zF5t"),a("5W5M"),a("z0WU"));function r(e){for(var t=1;t<arguments.length;t++){var a=null!=arguments[t]?arguments[t]:{},i=Object.keys(a);"function"==typeof Object.getOwnPropertySymbols&&(i=i.concat(Object.getOwnPropertySymbols(a).filter(function(e){return Object.getOwnPropertyDescriptor(a,e).enumerable}))),i.forEach(function(t){c(e,t,a[t])})}return e}function c(e,t,a){return t in e?Object.defineProperty(e,t,{value:a,enumerable:!0,configurable:!0,writable:!0}):e[t]=a,e}var p={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n      \t\t\t\t\t<div slot-scope="scope" class="btnBox">\n      \t\t\t\t\t\t\t<el-button v-show="colConfig.editBtns_isShow"  type="text" class="btns" style="font-size: 12px;" @click="colConfig.editBtns(scope.row,scope.$index)">编辑</el-button>\n      \t\t\t\t\t</div>\n    \t\t\t\t</el-table-column>'},m={props:["colConfig"],template:'<el-table-column :label="colConfig.label" :sortable="colConfig.sortable" align="center">\n\t\t\t\t\t\t<div slot-scope="scope">\n    \t\t\t\t\t\t<el-switch active-value="1" inactive-value="0" v-model="scope.row.isdisable" @change="colConfig.changeState(scope.row,scope.$index)"></el-switch>\n    \t\t\t\t\t</div>\n    \t\t\t   </el-table-column>'},d={data:function(){var e=this;return{guid:"",searchList:[{label:"公司编码",type:"input",mapKey:"code",configs:{},placeholder:"企业编码"},{label:"公司名称",type:"input",ruleType:"string",mapKey:"name",configs:{},placeholder:"企业名称"},{label:"是否启用",type:"select",ruleType:"string",mapKey:"isdisable",configs:{clearable:!0,name:"",options:[{value:"1",label:"是"},{value:"0",label:"否"}]},placeholder:"请选择"},{label:"管理员姓名",type:"input",ruleType:"string",mapKey:"userName",configs:{},placeholder:"管理员姓名"}],searchConfig:{hideSearchSwitch:!1},dialogLoading:!1,hideTime:700,dynaHeight:40,clientHeight:0,dynaHeightTimer:null,dynaHeightState:null,selectDataCompany:{data:{selectUrl:"/system/dictionary/getDictionarys",selectParm:{dictionaryKey:"companyType",isglobal:"1"}},defaultSelected:[]},selectDataRole:{data:{selectUrl:"/system/role/getRoles",selectParm:{queryStr:"(company_id = 'b6ff76cb95f711e884ad00163e105f05')"}},defaultSelected:[]},initConfigs:{tableOperates:{prop:"operate",label:"操作",enLabel:"operation",isPropName:!0,component:p,editBtns:this.editBtns,editBtns_isShow:!0}},configs:{queryBarBtnList:[{name:"查询",nameEn:"query",isShow:!0,icon:"search",method:this.initTable},{name:"重置",nameEn:"reset",isShow:!0,icon:"refresh",plain:!0,method:this.resetQueryTemp}],topBarBtnList:[{name:"新增",nameEn:"add",isShow:!0,icon:"add",method:this.addNew},{name:"删除",nameEn:"delete",isShow:!0,icon:"delete",plain:!0,state:!0,method:this.deleteBatch},{name:"导出",nameEn:"export",isShow:!0,icon:"export",method:this.exportExcel}],tableConfigs:[],showCheckBox:!1,showIndex:!1},tableData:[],selectList:null,dialogFormVisible:!1,dialogStatus:"",textMap:{update:"编辑菜单",create:"新增菜单"},temp:{},tempQuery:{},tempLable:{},tempNotEditable:{},rules:{code:[{required:!0,message:"请填写企业编码",trigger:"change"}],name:[{required:!0,message:"请填写企业名称",trigger:"change"}],companyValidityDate:[{required:!0,message:"请填写有效截至日期",trigger:"change"}],roleName:[{required:!0,trigger:"change",validator:function(t,a,i){e.selectDataRole.defaultSelected.length<=0?i(new Error("请选择角色")):i()}}],companyTypeName:[{required:!0,trigger:"change",validator:function(t,a,i){e.selectDataCompany.defaultSelected.length<=0?i(new Error("请选择企业性质")):i()}}],companyUserCount:[{required:!0,trigger:"blur",validator:function(e,t,a){""===t?a(new Error("请填写企业用户数")):t<1?a(new Error("企业用户数至少大于等于1!")):a()}}]},pageData:null,pageNo:1}},components:{searchBar:n.a},beforeCreate:function(){},created:function(){this.initButtons(),this.initTable(!0),this.dynaHeightState=this.$storage.get("dynaHeightState")||"1",this.dynaHeightState-0||(this.dynaHeight=0)},beforeMount:function(){},mounted:function(){this.clientHeight=this.$el.clientHeight},beforeUpdate:function(){},updated:function(){},methods:{searchMap:function(e){this.tempQuery=e,this.initTable()},sendGuid:function(e){this.guid=e},initButtons:function(){var e=this;e.$loading({spinner:"none",text:"智 造 云 管 家"});var t=e.$storage.get("userInfo").roleIds,a=e.$storage.get("menuId");t&&Object(l.initMenuButtons)({menuId:a,roleId:t}).then(function(t){var a=t.buttonList;a&&a.forEach(function(t){if(e.initConfigs&&e.initConfigs.tableOperates)for(var a in e.initConfigs.tableOperates)a.indexOf(t.nameEn)>=0&&a.indexOf("isShow")>0&&(e.initConfigs.tableOperates[a]=!1);if(e.customColumn)for(var i in e.customColumn)if(i){var n=e.customColumn[i];n.length>0&&n.forEach(function(e){if(e)for(var a in e)a.indexOf(t.nameEn)>=0&&a.indexOf("isShow")>0&&(e[a]=!1)})}e.configs&&(e.configs.queryBarBtnList&&e.configs.queryBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)}),e.configs.topBarBtnList&&e.configs.topBarBtnList.forEach(function(e){e.nameEn==t.nameEn&&(e.isShow=!1)}))})}).catch(function(t){e.$loading().close()})},initTable:function(e){var t=this;Object(o.listPageCompanyAdmins)(r({},t.tempQuery,{pageNo:t.pageNo})).then(function(a){t.getListPage(a),e&&t.$loading().close()}).catch(function(e){t.$loading().close()})},getListPage:function(e){if(e){this.pageData=e.result.pageData,this.initTempData(e.result.titles);var t=Object(s.j)(e.result),a=this.addTableTitle(t);this.configs.tableConfigs=a,this.configs.showCheckBox=!0,this.configs.showIndex=!0,this.tableData=e.result.varList,this.configs.topBarBtnList.forEach(function(e){"delete"==e.nameEn&&(e.state=!0)})}},initTempData:function(e){var t=this;e.forEach(function(e){for(var a in e){var n=e[a];n.indexOf("_")>0&&("en"==i.a.locale?n=n.substring(n.indexOf("_")+1):"zh"==i.a.locale&&(n=n.substring(0,n.indexOf("_")))),t.tempLable[a]=n,t.tempNotEditable[a]=!1}})},addTableTitle:function(e){var t=this;return e.forEach(function(e){var a=e.label;a.indexOf("_")>0&&("en"==i.a.locale?e.label=a.substring(a.indexOf("_")+1):"zh"==i.a.locale&&(e.label=a.substring(0,a.indexOf("_")))),"是否启用"===e.label&&(e.component=m,e.changeState=t.changeState)}),t.internationalConfig(),e.push(t.initConfigs.tableOperates),e},internationalConfig:function(){"en"==i.a.locale?(this.initConfigs.tableOperates.label="OPERATE",this.textMap.create="ADDNEW",this.textMap.update="EDIT"):"zh"==i.a.locale&&(this.initConfigs.tableOperates.label="操作",this.textMap.create="新增",this.textMap.update="编辑")},changeState:function(e,t){Object(o.updateDisableCompany)(e.id,e.isdisable).then(function(e){}).catch(function(e){})},dataBridge:function(e){this.selectList=e,e.length?this.configs.topBarBtnList.forEach(function(e){"delete"==e.nameEn&&(e.state=!1)}):this.configs.topBarBtnList.forEach(function(e){"delete"==e.nameEn&&(e.state=!0)})},editBtns:function(e,t){var a=this;a.resetTemp(),a.temp=JSON.parse(JSON.stringify(e)),a.tempNotEditable.code=!0,a.tempNotEditable.remark=!0,a.temp.companyType?a.selectDataCompany.defaultSelected=[a.temp.companyType]:a.selectDataCompany.defaultSelected=[],a.temp.roleId?a.selectDataRole.defaultSelected=[a.temp.roleId]:a.selectDataRole.defaultSelected=[],a.dialogStatus="update",a.dialogFormVisible=!0,a.$nextTick(function(){a.$refs.submitForm.clearValidate()})},updateData:function(){var e=this;e.$refs.submitForm.validate(function(t){t&&(e.dialogLoading=!0,Object(o.updateCompany)(e.temp).then(function(t){e.dialogLoading=!1,0===t.code&&(e.dialogFormVisible=!1,e.$notify({title:"成功",message:"修改成功",type:"success",duration:2e3}),e.refreshTable())}).catch(function(t){e.dialogLoading=!1}))})},addNew:function(){var e=this;this.resetTemp(),this.tempNotEditable.code=!1,this.tempNotEditable.remark=!0,this.dialogStatus="create",this.dialogFormVisible=!0,this.$nextTick(function(){e.$refs.submitForm.clearValidate()})},resetTemp:function(){for(var e in this.temp)this.temp[e]=""},resetQueryTemp:function(){for(var e in this.tempQuery)this.tempQuery[e]=""},createData:function(){var e=this;e.dialogLoading=!0,this.$refs.submitForm.validate(function(t){t&&(e.dialogLoading=!0,Object(o.addCompanyAdmin)(e.temp).then(function(t){e.dialogLoading=!1,0===t.code&&(e.dialogFormVisible=!1,e.$notify({title:"成功",message:"创建成功",type:"success",duration:2e3}),e.refreshTable())}).catch(function(t){e.dialogLoading=!1}))})},deleteBatch:function(){var e=this;e.$confirm("此操作将永久删除该记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){var t="",a="",i="";e.selectList.forEach(function(e){t+=e.id+",",a+=e.userRoleId+",",i+=e.userId+","}),t=t.slice(0,t.length-1),a=a.slice(0,a.length-1),i=i.slice(0,i.length-1),Object(o.deleteCompanyAdmins)(t,a,i).then(function(t){0===t.code&&(e.dialogFormVisible=!1,e.$notify({title:"成功",message:"删除成功",type:"success",duration:2e3}),e.refreshTable())}).catch(function(e){})}).catch(function(){e.$message({type:"info",message:"已取消删除"})})},refreshTable:function(){var e=this;e.$axios.all([Object(o.listPageCompanyAdmins)(r({},e.tempQuery,{pageNo:e.pageNo}))]).then(e.$axios.spread(function(t){e.getListPage(t)})).catch(function(e){})},companySelect:function(e,t){e[0]?(this.temp.companyType=e[0],this.selectDataCompany.defaultSelected=[e[0]]):(this.temp.companyType=[],this.selectDataCompany.defaultSelected=[])},roleSelect:function(e,t){e[0]?(this.selectDataRole.defaultSelected=[e[0]],this.temp.roleId=e[0]):(this.selectDataRole.defaultSelected=[],this.temp.roleId=[]),this.temp.remark=t?t.remark:[]},exportExcel:function(){var e="",t=this;null!=t.selectList&&t.selectList.length>0&&t.selectList.forEach(function(t){e=e+t.id+","}),Object(o.exportExcelCompanys)(e).then(function(e){e&&(Object(s.d)(e,"企业账号导出.xls"),t.$message({title:"成功",message:"导出成功",type:"success",duration:2e3}))}).catch(function(e){})}},computed:{tableHeight:function(){return this.$store.getters[this.guid+"/clientData"]?this.$store.getters[this.guid+"/clientData"].clientHeight-(this.searchList.length?this.$store.getters[this.guid+"/dynaHeight"]+30-this.$store.getters[this.guid+"/arrowBtn"]:0):0}},watch:{pageNo:function(){this.initTable()}}},u=(a("g3cN"),a("KHd+")),f=Object(u.a)(d,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"companyManage"},[e.searchList.length?a("search-bar",{attrs:{searchList:e.searchList,searchConfig:e.searchConfig},on:{"search-map":e.searchMap,"send-guid":e.sendGuid}}):e._e(),e._v(" "),a("el-row",{staticStyle:{border:"1px solid #E4E4E4","border-bottom":"none","margin-top":"10px",transition:"height 0.4s","-webkit-transition":"height 0.4s","-moz-transition":"height 0.4s"},style:{height:e.tableHeight+"px"}},[a("el-col",{staticClass:"tableStyle"},[a("div",{staticClass:"baseTable"},[a("el-row",{staticClass:"tableTopBar"},[a("el-col",[a("div",{staticClass:"tableBtns"},[e._l(e.configs.topBarBtnList,function(e,t){return[a("base-button",{directives:[{name:"show",rawName:"v-show",value:e.isShow,expression:"item.isShow"}],attrs:{name:e.name,icon:e.icon,plain:e.plain,state:e.state},on:{myclick:e.method}})]})],2)])],1),e._v(" "),a("el-row",{staticClass:"tableContent"},[a("base-table",{attrs:{data:e.tableData,colConfigs:e.configs.tableConfigs,showCheckBox:e.configs.showCheckBox,showIndex:e.configs.showIndex,pageData:e.pageData,currentpage:e.pageNo},on:{databridge:e.dataBridge,"update:currentpage":function(t){e.pageNo=t}}})],1)],1)])],1),e._v(" "),a("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.textMap[e.dialogStatus],visible:e.dialogFormVisible,width:"800px",top:"40px"},on:{"update:visible":function(t){e.dialogFormVisible=t}}},[a("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogLoading,expression:"dialogLoading"}]},[a("el-form",{ref:"submitForm",staticStyle:{width:"600px",margin:"10px auto"},attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"120px"}},[a("el-row",[a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:e.tempLable.code+":",prop:"code"}},[a("el-input",{attrs:{disabled:e.tempNotEditable.code},model:{value:e.temp.code,callback:function(t){e.$set(e.temp,"code",t)},expression:"temp.code"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:e.tempLable.name+":",prop:"name"}},[a("el-input",{model:{value:e.temp.name,callback:function(t){e.$set(e.temp,"name",t)},expression:"temp.name"}})],1)],1)],1),e._v(" "),a("el-row",[a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:e.tempLable.companyShortname+":",prop:"companyShortname"}},[a("el-input",{model:{value:e.temp.companyShortname,callback:function(t){e.$set(e.temp,"companyShortname",t)},expression:"temp.companyShortname"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:e.tempLable.serialNumber+":",prop:"serialNumber"}},[a("el-input",{model:{value:e.temp.serialNumber,callback:function(t){e.$set(e.temp,"serialNumber",t)},expression:"temp.serialNumber"}})],1)],1)],1),e._v(" "),a("el-row",[a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:e.tempLable.companyTypeName,prop:"companyTypeName"}},[a("base-input-select",{staticStyle:{width:"180px"},attrs:{placeholder:e.tempLable.companyTypeName,data:e.selectDataCompany.data},on:{callback:e.companySelect},model:{value:e.selectDataCompany.defaultSelected,callback:function(t){e.$set(e.selectDataCompany,"defaultSelected",t)},expression:"selectDataCompany.defaultSelected"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:e.tempLable.companyValidityDate+":",prop:"companyValidityDate"}},[a("el-date-picker",{staticStyle:{width:"180px"},attrs:{type:"date",placeholder:"选择日期","value-format":"yyyy-MM-dd"},model:{value:e.temp.companyValidityDate,callback:function(t){e.$set(e.temp,"companyValidityDate",t)},expression:"temp.companyValidityDate"}})],1)],1)],1),e._v(" "),a("el-row",[a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:e.tempLable.userName+":",prop:"userName"}},[a("el-input",{model:{value:e.temp.userName,callback:function(t){e.$set(e.temp,"userName",t)},expression:"temp.userName"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:e.tempLable.mobile+":",prop:"mobile"}},[a("el-input",{model:{value:e.temp.mobile,callback:function(t){e.$set(e.temp,"mobile",t)},expression:"temp.mobile"}})],1)],1)],1),e._v(" "),a("el-row",[a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:e.tempLable.email+":",prop:"email"}},[a("el-input",{model:{value:e.temp.email,callback:function(t){e.$set(e.temp,"email",t)},expression:"temp.email"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:e.tempLable.companyUserCount+":",prop:"companyUserCount"}},[a("el-input",{model:{value:e.temp.companyUserCount,callback:function(t){e.$set(e.temp,"companyUserCount",t)},expression:"temp.companyUserCount"}})],1)],1)],1),e._v(" "),a("el-row",[a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:e.tempLable.roleName,prop:"roleName"}},[a("base-input-select",{staticStyle:{width:"180px"},attrs:{placeholder:e.tempLable.roleName,data:e.selectDataRole.data},on:{callback:e.roleSelect},model:{value:e.selectDataRole.defaultSelected,callback:function(t){e.$set(e.selectDataRole,"defaultSelected",t)},expression:"selectDataRole.defaultSelected"}})],1)],1)],1),e._v(" "),a("el-row",[a("el-col",{attrs:{span:24}},[a("el-form-item",{attrs:{label:e.tempLable.remark+":",prop:"remark"}},[a("el-input",{attrs:{disabled:e.tempNotEditable.remark},model:{value:e.temp.remark,callback:function(t){e.$set(e.temp,"remark",t)},expression:"temp.remark"}})],1)],1)],1)],1),e._v(" "),a("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"30px"},attrs:{slot:"footer"},slot:"footer"},["create"==e.dialogStatus?a("el-button",{attrs:{type:"primary"},on:{click:e.createData}},[e._v("保存")]):a("el-button",{attrs:{type:"primary"},on:{click:e.updateData}},[e._v("保存")]),e._v(" "),a("el-button",{on:{click:function(t){e.dialogFormVisible=!1}}},[e._v("关闭")])],1)],1)])],1)},[],!1,null,null,null);f.options.__file="index.vue";t.default=f.exports},g3cN:function(e,t,a){"use strict";var i=a("5NjW");a.n(i).a}}]);