(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-7d72"],{DB55:function(e,t,i){"use strict";var o=i("dI5m");i.n(o).a},dI5m:function(e,t,i){},jcWM:function(e,t,i){"use strict";i.r(t);var o=i("2+ib"),a=(i("z0WU"),i("Ppn9")),n={name:"dialog-option",props:["initData","visible"],data:function(){return{dialogTopLoading:!1,isVisible:!1,title:"",userInfo:null,tableConfigList:[{customColumn:[{columnIndex:"name","min-width":160,_cellConfig:{hideTitle:!0,bodyStyle:{color:"#199ED4","font-weight":600,width:"100%"},events:{type:"file",path:"url"}}},{columnIndex:"relativeUrl","min-width":250,_cellConfig:{hideTitle:!0}},{columnIndex:"cdate","min-width":120,_cellConfig:{hideTitle:!0}},{columnIndex:"last",prop:"operate",label:"操作",componentName:"button",component:[{name:"删除",nameEn:"delete",editBtns_isShow:!0,icon:"delete",method:this.delete}]}],apiObj:{apiName:"listPageBoms",params:{fieldCode:"prodCode,prodName,prodSpec,genreName,unitName,planCount",modelCode:"BomProduct",isdefault:"1",queryStr:" bom.id is not null "}},temp:{},showIndex:!0,showHeader:!0,showCheckBox:!0,showTableSet:!1,showAll:!1,componentId:"oneLevelTable",expand:!1,expandMode:"none",showExpandBtn:!0,headerStyle:{"background-color":"#E4F3FA"},rowStyle:{"background-color":"#E4F3FA"}}],selectList:[],openDialogName:"",showDialog:!1,visibleState:!1,dialogData:{title:"",temp:null,tempLable:null}}},components:{multilevelTable:o.a},beforeCreate:function(){},created:function(){this.title=this.initData.title,this.userInfo=this.$storage.get("userInfo")},beforeMount:function(){},mounted:function(){this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{dialogClose:function(){this.$emit("close-dialog",{resState:"ok",selectList:[]})},addProduct:function(){this.selectList.length>0?this.$emit("close-dialog",{resState:"ok",selectList:this.selectList}):this.$message({type:"warning",duration:5e3,showClose:!0,message:"请至少选择一条记录！"})},getData:function(){this.$refs.customBaseTable.getData()},pushData:function(e,t){this.$refs.customBaseTable.pushData(e,t)},updateData:function(e){this.selectList=[],this.$refs.customBaseTable.updateData(e)},deleteData:function(e){this.$refs.customBaseTable.deleteData(e)},callMethod:function(e){e&&e.methodName&&this[e.methodName](e.params)},delete:function(e,t){var i=this;i.$confirm("此操作将永久删除该记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){Object(a.deleteAttachment)(e).then(function(e){0===e.code&&(i.$notify({title:"成功",message:"删除成功",type:"success",duration:2e3}),i.updateData())}).catch(function(e){console.log(e)})}).catch(function(){i.$message({type:"info",message:"已取消删除"})})},closeDialog:function(e){this.showDialog=!1,"ok"===e.resState&&this.updateData()},databridge:function(e){this.selectList=e}},computed:{dialogName:function(){return this.openDialogName}},watch:{}},l=(i("DB55"),i("KHd+")),s=Object(l.a)(n,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.title,visible:e.isVisible,"append-to-body":"",width:"900px"},on:{"update:visible":function(t){e.isVisible=t},close:e.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogTopLoading,expression:"dialogTopLoading"}],staticStyle:{height:"500px"}},[i("el-col",{staticStyle:{height:"100%"},attrs:{span:24}},[i("div",{staticStyle:{height:"calc(100% - 0px)","box-sizing":"border-box",padding:"7px"}},[i("el-row",{staticClass:"tableContent"},[i("multilevel-table",{ref:"customBaseTable",attrs:{tableConfigList:e.tableConfigList},on:{callmethod:e.callMethod,databridge:e.databridge}})],1)],1)]),e._v(" "),e.showDialog?i(e.dialogName,{tag:"component",attrs:{initData:e.dialogData,visible:e.visibleState},on:{"close-dialog":e.closeDialog}}):e._e()],1),e._v(" "),i("div",{staticClass:"dialog-footer",staticStyle:{"text-align":"center","padding-bottom":"10px"},attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:e.addProduct}},[e._v("确定")]),e._v(" "),i("el-button",{on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)])},[],!1,null,null,null);s.options.__file="dialogaddProduct.vue";t.default=s.exports}}]);