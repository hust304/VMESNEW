(window.webpackJsonp=window.webpackJsonp||[]).push([["YIaj"],{YIaj:function(e,t,i){"use strict";i.r(t);i("f3/d");var s=i("1FtD"),o=i("z0WU"),l={name:"dialog-import-excel",props:["initData","visible"],data:function(){return{dialogTopLoading:!1,isVisible:!1,title:"文件导入",importUrl:"",exportUrl:"",userInfo:null,excelFileList:[],excelData:{},fieldCode:"warehouseCode,pathName,productCode,productName,productSpec,productGenreName,productUnitName,stockCount"}},components:{},beforeCreate:function(){},created:function(){this.initData.title&&(this.title=this.initData.title),this.importUrl="http://web.deecoop.cn/"+this.initData.importUrl,this.initData.excelData&&(this.excelData=this.initData.excelData),this.$storage.get("userInfo")&&(this.excelData.companyId=this.$storage.get("userInfo").companyId,this.excelData.userId=this.$storage.get("userInfo").userId,this.excelData.warehouseGenre="warehouse")},beforeMount:function(){},mounted:function(){this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{dialogClose:function(e){this.$emit("close-dialog",e||{})},importExcelChangeFile:function(e,t){this.excelFileList=[t[t.length-1]]},importExcelBeforeUpload:function(e){null!=this.excelFileList&&this.excelFileList.length>1&&this.$message({showClose:!0,message:"只能选择一个导入文件，请删除多余的导入列表！",type:"warning",duration:5e3});var t=e.name,i="";if(-1!=t.indexOf(".")&&(i=t.substr(t.indexOf(".")+1,t.length)),-1!="xls,xlsx".indexOf(i)){e.size>10485760&&this.$message({showClose:!0,message:"Excel导入文件大小不能超过 5MB!",type:"error",duration:5e3})}else this.$message({showClose:!0,message:"Excel导入文件只能支持(xls,xlsx)格式!",type:"error",duration:5e3})},importExcelSuccess:function(e){this.dialogTopLoading=!1;var t="";null!=e.msg&&e.msg.trim().length>0&&(t=e.msg.trim()),0==e.code?(this.isVisible=!1,this.$message({showClose:!0,message:t,type:"success",duration:5e3}),this.dialogClose({resState:"ok"})):0!=e.code&&this.$message({showClose:!0,message:t,type:"error",duration:0}),this.$refs.upload.clearFiles()},importExcelSubmit:function(){null==this.excelFileList||0!=this.excelFileList.length?(this.dialogTopLoading=!0,this.$refs.upload.submit()):this.$message({showClose:!0,message:"请选择导入文件！",type:"warning",duration:5e3})},exportExcelFunction:function(){var e=this;Object(s.exportExcelTemplateWarehouseInitial)({fieldCode:this.fieldCode}).then(function(t){Object(o.g)(t,"仓库货品导入.xls"),e.$message({title:"成功",message:"Excel仓库货品导入模板下载成功",type:"success",duration:2e3})}).catch(function(e){})}},computed:{},watch:{}},a=i("KHd+"),n=Object(a.a)(l,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.title,visible:e.isVisible,width:"500px",top:"40px","append-to-body":""},on:{"update:visible":function(t){e.isVisible=t},close:e.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogTopLoading,expression:"dialogTopLoading"}],staticStyle:{"text-align":"left","padding-left":"50px","padding-top":"20px","line-height":"20px"}},[i("span",{staticStyle:{"font-size":"16px","padding-bottom":"5px"}},[e._v("操作步骤：")]),i("br"),e._v("\n    1."),i("a",{staticStyle:{color:"#169BD5"},on:{click:e.exportExcelFunction}},[e._v("点击此处下载模板")]),i("br"),e._v("\n    2.按示例填写需要导入的数据信息"),i("br"),e._v("\n    3.请将Excel模板中示例信息删除"),i("br"),e._v("\n    4.上传过程中不要多次提交或刷新页面"),i("br"),e._v("\n    5.Excel导入文件只能支持(xls,xlsx)格式，且文件大小不能超过10M"),i("br"),i("br"),e._v(" "),i("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{name:"excelFile",action:e.importUrl,"on-change":e.importExcelChangeFile,"before-upload":e.importExcelBeforeUpload,"on-success":e.importExcelSuccess,data:e.excelData,"file-list":e.excelFileList,"auto-upload":!1}},[i("el-button",{attrs:{slot:"trigger",size:"small",type:"primary"},slot:"trigger"},[e._v("选取文件")]),e._v(" "),i("el-button",{attrs:{size:"small",type:"success"},on:{click:e.importExcelSubmit}},[e._v("导入")])],1),e._v(" "),i("br"),i("br")],1)])},[],!1,null,null,null);n.options.__file="dialogImportExcel.vue";t.default=n.exports}}]);