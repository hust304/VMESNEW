(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-3b8b"],{"0iCw":function(e,n,t){"use strict";var i=t("4osE");t.n(i).a},"4osE":function(e,n,t){},KuY0:function(e,n,t){"use strict";t.r(n);t("rE2o"),t("ioFf"),t("rGqo"),t("yt8O"),t("RW0V"),t("Z2Ku"),t("L9s1");var i=t("z0WU");function o(e){return(o="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e})(e)}var a={name:"authority-tree-component",props:{config:{type:Object,default:function(){return{}}}},computed:{},data:function(){return{componentNameList:["radio","switch"],treeData:[],handleNodeClickTimer:"",checkboxGroup:{},checkAll:{},isIndeterminate:{}}},created:function(){this.httpRequest()},watch:{"config.apiObj.params":function(){this.httpRequest()}},methods:{httpRequest:function(){var e=this;this.config.apiObj&&this.config.apiObj.apiName&&(this.checkboxGroup={},this.checkAll={},this.isIndeterminate={},this.$api[this.config.apiObj.apiName](this.config.apiObj.params).then(function(n){if(console.log(n),n.result)if("string"==typeof n.result){var t=JSON.parse(n.result);t&&(Array.isArray(t)&&(e.treeData=e.formatFn(0,t)),"object"===o(t)&&Object.keys(t).includes("treeList")&&(e.treeData=Array.isArray(t.treeList)?e.formatFn(0,t.treeList):e.formatFn(0,[t.treeList])))}else Array.isArray(n.result)?e.treeData=e.formatFn(0,n.result):Array.isArray(n.result)||"object"!==o(n.result)?e.treeData=[]:Object.keys(n.result).includes("treeList")&&(e.treeData=Array.isArray(n.result.treeList)?e.formatFn(0,n.result.treeList):e.formatFn(0,[n.result.treeList]));else e.treeData=[]}).catch(function(e){console.log(e)}))},radioChange:function(e){},formatFn:function(e,n){var t=this;return n.map(function(n){if(n._layer=e,"0"===t.$storage.get("userInfo").userId&&("radio"===t.config.componentName&&(!Object.keys(n).includes("bindValue")&&(n.bindValue="1")),"checkbox"===t.config.componentName&&(!Object.keys(n).includes("bindValue")&&(n.bindValue=t.roundId('[{"id":"3b133abe4f3544c5952dd678a780c790","name":"恢复","nameEn":"recoveryByParent","serialNumber":5,"isdisable":"1","isBindRole":"1"},{"id":"6e088d007c99458a8a90d96ff210a59f","name":"删除","nameEn":"deleteByParent","serialNumber":3,"isdisable":"1","isBindRole":"1"},{"id":"715398ca1a0e4dd8b1e2a11bb26ee101","name":"新增","nameEn":"add","serialNumber":1,"isdisable":"1","isBindRole":"1"},{"id":"760255102b494f769e1e6dc0490a4afd","name":"业务信息","nameEn":"orderByParent","serialNumber":7,"isdisable":"1","isBindRole":"1"},{"id":"c3523f114a6a4ff182ff21e26cd6f805","name":"执行","nameEn":"executeByParent","serialNumber":6,"isdisable":"1","isBindRole":"1"},{"id":"e2002b785c9044b48cd1cb727e27fa8a","name":"取消","nameEn":"cancelByParent","serialNumber":4,"isdisable":"1","isBindRole":"1"},{"id":"f6a0db1a0e784687b7e307820c53ffde","name":"编辑","nameEn":"editByParent","serialNumber":2,"isdisable":"1","isBindRole":"1"}]')))),"checkbox"===t.config.componentName&&t.config.bindValue[n._layer]&&n[t.config.bindValue[n._layer]]){var i=n[t.config.componentConfig.keyName||"id"],o=n[t.config.bindValue[n._layer]],a=o.filter(function(e){return"1"===e[t.config.componentConfig.stateName]}).map(function(e){return e[t.config.componentConfig.keyName||"id"]});Object.keys(t.checkboxGroup).includes(i)?t.checkboxGroup[i]=a:t.$set(t.checkboxGroup,i,a),Object.keys(t.checkAll).includes(i)?t.checkAll[i]=a.length===o.length:t.$set(t.checkAll,i,a.length===o.length),Object.keys(t.isIndeterminate).includes(i)?t.isIndeterminate[i]=o.length&&a.length<o.length:t.$set(t.isIndeterminate,i,o.length&&a.length<o.length)}return n.children&&n.children.length&&t.formatFn(n._layer+1,n.children),n})},handleNodeClick:function(e,n,t){var i=this;this.config.throwTreeNode&&(clearTimeout(this.handleNodeClickTimer),this.handleNodeClickTimer=setTimeout(function(n){i.$emit("treedatabridge",e)},10))},indeterminateChange:function(e,n){var t=this,i=e.length,o=n[this.config.bindValue[n._layer]];o.forEach(function(n){e.includes(n[t.config.componentConfig.keyName||"id"])||(n[t.config.componentConfig.stateName]="0")}),this.checkAll[n[this.config.componentConfig.keyName||"id"]]=i===o.length,this.isIndeterminate[n[this.config.componentConfig.keyName||"id"]]=i>0&&i<o.length},handleCheckAllChange:function(e,n){var t=this,i=n[this.config.bindValue[n._layer]];i.forEach(function(n){n[t.config.componentConfig.stateName]=e?"1":"0"}),this.checkboxGroup[n[this.config.componentConfig.keyName||"id"]]=e?i.map(function(e){return e[t.config.componentConfig.keyName||"id"]}):[],this.isIndeterminate[n[this.config.componentConfig.keyName||"id"]]=!1},roundId:function(e){var n;return"string"==typeof e?(n=JSON.parse(e),Array.isArray(n)&&(n=n.map(function(e){return e.id=Object(i.p)(),e}))):n=e.map(function(e){return e.id=Object(i.p)(),e}),n},getTreeData:function(){this.$emit("treedatabridge",this.treeData)}}},c=(t("coFF"),t("KHd+")),r=Object(c.a)(a,function(){var e=this,n=e.$createElement,t=e._self._c||n;return t("div",{staticClass:"authority-tree-component"},[t("el-tree",{style:{width:e.config.width||"100%",background:e.config.treeWidth?"linear-gradient(to right, "+e.config.treeBackgroundColor+" "+e.config.treeWidth+"px, #ffffff "+e.config.treeWidth+"px)":"inherit"},attrs:{data:e.treeData,"show-checkbox":e.config["show-checkbox"]||!1,"node-key":"id","default-expand-all":e.config["default-expand-all"]||!1,"highlight-current":e.config["highlight-current"]||!1,accordion:e.config.accordion||!1,"expand-on-click-node":!1,props:e.config.props||{label:"name"}},on:{"node-click":e.handleNodeClick},scopedSlots:e._u([{key:"default",fn:function(n){var i=n.node,o=n.data;return t("span",{staticClass:"custom-tree-node"},[t("span",[e._v(e._s(i.label))]),e._v(" "),"radio"===e.config.componentName?[e.config.componentList[o._layer]&&e.config.componentList[o._layer].length?[o.children&&!o.children.length?t("span",{style:{width:"calc(100% - "+(e.config.treeWidth||0)+"px)","text-align":"center"}},[t("el-radio-group",{attrs:{size:e.config.componentConfig.size||"mini"},on:{change:e.radioChange},model:{value:o[e.config.bindValue[o._layer]],callback:function(n){e.$set(o,e.config.bindValue[o._layer],n)},expression:"data[config.bindValue[data._layer]]"}},[e._l(e.config.componentList[o._layer],function(n){return[t("el-radio",{attrs:{border:e.config.componentConfig.border,disabled:"0"===o[e.config.componentConfig.disabled],label:n.label}},[e._v(e._s(n.text))])]})],2)],1):e._e()]:e._e()]:["checkbox"===e.config.componentName&&o[e.config.bindValue[o._layer]]&&o[e.config.bindValue[o._layer]].length?[t("span",{style:{width:"calc(100% - "+(e.config.treeWidth||0)+"px)",display:"flex","align-items":"center","justify-content":"space-between"}},[t("el-checkbox-group",{staticStyle:{display:"inline-block"},attrs:{size:e.config.componentConfig.size||"mini"},on:{change:function(n){return e.indeterminateChange(n,o)}},model:{value:e.checkboxGroup[o[e.config.componentConfig.keyName||"id"]],callback:function(n){e.$set(e.checkboxGroup,o[e.config.componentConfig.keyName||"id"],n)},expression:"checkboxGroup[data[config.componentConfig.keyName || 'id']]"}},[e._l(o[e.config.bindValue[o._layer]],function(n){return[t("el-checkbox",{key:n.id,attrs:{border:e.config.componentConfig.border,disabled:"0"===n[e.config.componentConfig.disabled],label:n[e.config.componentConfig.keyName||"id"]}},[e._v(e._s(n[e.config.componentConfig.labelName||"name"]))])]})],2),e._v(" "),t("el-checkbox",{attrs:{indeterminate:e.isIndeterminate[o[e.config.componentConfig.keyName||"id"]]},on:{change:function(n){return e.handleCheckAllChange(n,o)}},model:{value:e.checkAll[o[e.config.componentConfig.keyName||"id"]],callback:function(n){e.$set(e.checkAll,o[e.config.componentConfig.keyName||"id"],n)},expression:"checkAll[data[config.componentConfig.keyName || 'id']]"}},[t("span",{staticStyle:{"font-weight":"bold",color:"#000000"}},[e._v("全选")])])],1)]:e._e()]],2)}}])})],1)},[],!1,null,null,null);r.options.__file="index.vue";var l={name:"authority",components:{authorityTree:r.exports},data:function(){return{treeConfig:{treeWidth:250,treeBackgroundColor:"#e0e0e0",throwTreeNode:!1,disabled:"isdisable",accordion:!1,"show-checkbox":!1,"highlight-current":!1,"default-expand-all":!0,props:{label:"name"},width:"1000px",apiObj:{apiName:"treeRoleMeunsSelected",params:{roleIds:"e0af062de24046a385f9319dbad8d875"}},componentName:"checkbox",componentConfig:{border:!1,size:"mini",disabled:"isdisable",keyName:"id",labelName:"name",stateName:"isBindRole"},bindValue:["","bindValue"]}}},created:function(){},methods:{treedatabridge:function(e){console.log(e)},getTreeData:function(){this.$refs.authorityTree.getTreeData&&this.$refs.authorityTree.getTreeData()}}},s=(t("0iCw"),Object(c.a)(l,function(){var e=this.$createElement,n=this._self._c||e;return n("div",{staticClass:"authorityTree"},[n("div",{staticStyle:{height:"calc(100% - 60px)"}},[n("authority-tree",{ref:"authorityTree",attrs:{config:this.treeConfig},on:{treedatabridge:this.treedatabridge}})],1),this._v(" "),n("div",{staticStyle:{height:"60px"}},[n("el-button",{attrs:{type:"primary"},on:{click:this.getTreeData}},[this._v("获取树数据")])],1)])},[],!1,null,"71470dfb",null));s.options.__file="index.vue";n.default=s.exports},coFF:function(e,n,t){"use strict";var i=t("kGNP");t.n(i).a},kGNP:function(e,n,t){}}]);