(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-c6c5"],{"50wx":function(e,t,i){},B4iC:function(e,t,i){"use strict";i.r(t);i("yt8O"),i("RW0V"),i("rGqo"),i("f3/d"),i("mSNy");var n=i("t3Un");i("z0WU");function r(e,t,i){return t in e?Object.defineProperty(e,t,{value:i,enumerable:!0,configurable:!0,writable:!0}):e[t]=i,e}var a={name:"dialog-tree",props:["initData","visible"],data:function(){return{dialogTopLoading:!1,isVisible:!1,title:"选择框",treeData:[],treeConfigs:r({ref:"tree",showCheckBox:!0,showIcons:!1,expandAll:!1,defaultProps:null},"showIcons",!1),selectTree:{pid:"",id:"",layer:"",name:""},filterText:"",enterTime:0,showDisable:!1,treeNodes:[],userInfo:null}},components:{},beforeCreate:function(){},created:function(){this.title=this.initData.title,this.userInfo=this.$storage.get("userInfo"),this.initTree()},beforeMount:function(){},mounted:function(){this.isVisible=this.visible},beforeUpdate:function(){},updated:function(){},methods:{dialogClose:function(){this.$emit("close-dialog",this.selectTree,this.initData.temp)},initTree:function(){var e=this;e.dialogTopLoading=!0,Object(n.a)({url:e.initData.treeUrl,method:"post",data:function(e){for(var t=1;t<arguments.length;t++){var i=null!=arguments[t]?arguments[t]:{},n=Object.keys(i);"function"==typeof Object.getOwnPropertySymbols&&(n=n.concat(Object.getOwnPropertySymbols(i).filter(function(e){return Object.getOwnPropertyDescriptor(i,e).enumerable}))),n.forEach(function(t){r(e,t,i[t])})}return e}({},e.initData.treeParm)}).then(function(t){e.dialogTopLoading=!1,e.loadTree(t)}).catch(function(t){console.log(t),e.dialogTopLoading=!1})},loadTree:function(e){var t=this,i=[],n=e.result.treeList;i.push(n),t.treeData=i,t.treeNodes=[],t.circleTree(t.treeData,t.showDisable,t.filterText,t.treeNodes),t.selectTree={pid:n.pid,id:n.id,layer:n.layer,name:n.name},t.$nextTick(function(){if(t.treeNodes.length>0){var e=t.treeNodes[0];t.selectTree={pid:e.pid,id:e.id,layer:e.layer,name:e.name}}t.$refs.tree.$children[0].setCurrentKey(t.selectTree.id)})},treeDataBridge:function(e){console.log(e);this.selectTree={pid:e.nodeData.pid,id:e.nodeData.id,layer:e.nodeData.layer,name:e.nodeData.name},this.$refs.tree.$children[0].setCurrentKey(this.selectTree.id)},searchByName:function(){var e=this;e.treeNodes=[],e.circleTree(e.treeData,e.showDisable,e.filterText,e.treeNodes),e.enterTime=e.enterTime+1,e.$nextTick(function(){if(e.treeNodes.length>0){var t=e.treeNodes[e.enterTime%e.treeNodes.length];e.selectTree={pid:t.pid,id:t.id,layer:t.layer,name:t.name}}e.$refs.tree.$children[0].setCurrentKey(e.selectTree.id)})},circleTree:function(e,t,i,n){var r=this;e.length>0&&e.forEach(function(a){if(t)i&&a.name.indexOf(i)>-1&&n.push(a);else if("1"==a.isdisable)i&&a.name.indexOf(i)>-1&&n.push(a);else{var o=e.indexOf(a);o>-1&&e.splice(o,1)}a.children.length>0&&r.circleTree(a.children,t,i,n)})}},computed:{},watch:{showDisable:function(){this.initTree()}}},o=(i("fMx0"),i("KHd+")),l=Object(o.a)(a,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{directives:[{name:"el-drag-dialog",rawName:"v-el-drag-dialog"}],attrs:{title:e.title,visible:e.isVisible,"append-to-body":"",width:"300px"},on:{"update:visible":function(t){e.isVisible=t},close:e.dialogClose}},[i("div",{directives:[{name:"loading",rawName:"v-loading",value:e.dialogTopLoading,expression:"dialogTopLoading"}],staticStyle:{height:"500px"}},[i("div",{staticStyle:{position:"relative",height:"90%",overflow:"hidden"}},[i("div",{staticStyle:{position:"absolute",top:"-10px",bottom:"-10px",left:"0",right:"5px","box-shadow":"5px 0 10px -5px rgba(0,0,0,0.3)","box-sizing":"border-box",padding:"20px 0"}},[i("div",{staticStyle:{"box-sizing":"border-box",padding:"0 10px",overflow:"auto"},style:e.treeData.length?"height: 100%":""},[i("div",{staticStyle:{width:"90%",margin:"5px auto"}},[i("el-input",{attrs:{placeholder:"名称",clearable:""},nativeOn:{keyup:function(t){return"button"in t||!e._k(t.keyCode,"enter",13,t.key,"Enter")?e.searchByName(t):null}},model:{value:e.filterText,callback:function(t){e.filterText=t},expression:"filterText"}},[i("i",{staticClass:"el-input__icon el-icon-search",attrs:{slot:"suffix"},slot:"suffix"})])],1),e._v(" "),i("div",{staticStyle:{padding:"5px 0px 10px 20px"}},[i("el-checkbox",{model:{value:e.showDisable,callback:function(t){e.showDisable=t},expression:"showDisable"}},[e._v("显示封存")])],1),e._v(" "),i("div",{staticStyle:{"padding-left":"20px"}},[i("base-tree",{ref:"tree",attrs:{data:e.treeData,treeConfigs:e.treeConfigs},on:{treedatabridge:e.treeDataBridge}})],1)])])]),e._v(" "),i("div",{staticStyle:{"text-align":"center",position:"relative",top:"5px","padding-bottom":"10px"}},[i("el-button",{attrs:{type:"primary",disabled:!e.selectTree.id},on:{click:function(t){e.isVisible=!1}}},[e._v("确认")]),e._v(" "),i("el-button",{staticStyle:{"margin-left":"30px"},on:{click:function(t){e.isVisible=!1}}},[e._v("关闭")])],1)])])},[],!1,null,null,null);l.options.__file="dialogTree.vue";t.default=l.exports},fMx0:function(e,t,i){"use strict";var n=i("50wx");i.n(n).a}}]);