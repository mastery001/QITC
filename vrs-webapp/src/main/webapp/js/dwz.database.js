/**
 * @author ZhangHuihua@msn.com
 */
(function($) {
	var _lookup = {
		currentGroup : "",
		suffix : "",
		$target : null,
		pk : "id"
	};
	var _util = {
		_lookupPrefix : function(key) {
			var strDot = _lookup.currentGroup ? "." : "";
			return _lookup.currentGroup + strDot + key + _lookup.suffix;
		},
		lookupPk : function(key) {
			return this._lookupPrefix(key);
		},
		lookupField : function(key) {
			return this.lookupPk(key);
		}
	};

	$
			.extend({
				bringBackSuggest : function(args) {
					var $box = _lookup['$target'].parents(".unitBox:first");
					$box.find(":input").each(
							function() {
								var $input = $(this), inputName = $input
										.attr("name");
								for ( var key in args) {
									var name = (_lookup.pk == key) ? _util
											.lookupPk(key) : _util
											.lookupField(key);

									if (name == inputName) {
										$input.val(args[key]);
										break;
									}
								}
							});
				},

				bringBackSuggest1 : function(args) {
					var $box = _lookup['$target'].parents(".unitBox:first");
					$box.find("textarea").each(
							function() {
								var $textarea = $(this), inputName = $textarea
										.attr("name");
								for ( var key in args) {
									var name = (_lookup.pk == key) ? _util
											.lookupPk(key) : _util
											.lookupField(key);
									if (name == inputName) {
										$textarea.val(args[key]);
										break;
									}
								}
							});
				},
				bringBackindexSuggest : function(args) {
					var $box = _lookup['$target'].parents(".unitBox:first");
					$box.find(":input").each(
							function() {
								var $input = $(this), inputName = $input
										.attr("callBack");
								for ( var key in args) {
									var name = (_lookup.pk == key) ? _util
											.lookupPk(key) : _util
											.lookupField(key);

									if (name == inputName) {
										$input.val(args[key]);
										break;
									}
								}
							});
				},
				bringBack : function(args) {
					$.bringBackSuggest(args);
					$.pdialog.closeCurrent();
				},

				// 增加textarea、radio、checkbox等元素的处理
				bringBackByAlbumSearch : function(args) {
					var $box = _lookup['$target'].parents(".unitBox:first");
					var $accurate = $('#accurate');
					if ($accurate && $accurate.length
							&& $accurate.is(":checked") == false) {
						$.bringBack({
							'pid' : args['video.pid'],
							'cid' : args.cid
						});
						return;
					}
					// radio && text
					$box.find(":input").each(
							function() {
								var $input = $(this), inputName = $input
										.attr("name"), inputType = $input
										.attr("type");
								if (inputType == 'checkbox') {
									return true;
								}
								for ( var key in args) {
									if (key == inputName) {
										if (inputType == 'text') {
											$input.val(args[key]);
										} else if (inputType == 'radio'
												&& $input.val() == args[key]) {
											$(
													'input[name="' + inputName
															+ '"]', $box)
													.removeAttr('checked');
											$input.attr('checked', true);
										}
										break;
									}
								}
							});

					// textarea
					$box.find("textarea").each(function() {
						var $input = $(this), inputName = $input.attr("name");
						for ( var key in args) {
							if (key == inputName) {
								$input.val(args[key]);
								break;
							}
						}
					});

					// checkbox
					for ( var key in args) {
						if (typeof args[key] == 'string') {
							continue;
						}
						$box
								.find(':checkbox[name="' + key + '"]')
								.removeAttr('checked')
								.each(
										function() {
											var $input = $(this);
											for (var i = 0, len = args[key].length; i < len; i += 1) {
												if (args[key][i] == $input
														.val()) {
													$input
															.attr('checked',
																	true);
												}
											}

										});
					}

					$.pdialog.closeCurrent();
				},

				// 专辑编辑页 － 视频管理 － 添加视频 － 回调 处理
				bringBackByAlbumAddVideo : function(args) {
					$.ajax({
						type : 'POST',
						url : '../video/doBatchAddVideoToAlbum.action',
						data : args,
						dataType : "json",
						cache : false,
						success : navTabAjaxDone,
						error : DWZ.ajaxError
					});
					$.pdialog.closeCurrent();
				},
				// 音频专辑编辑页 － 添加音频 － 回调 处理
				bringBackByAudioAlbumAddAudio : function(args) {
					$.ajax({
						type : 'POST',
						url : '../audio/batchAddToAlbum.action',
						data : args,
						dataType : "json",
						cache : false,
						success : navTabAjaxDone,
						error : DWZ.ajaxError
					});
					$.pdialog.closeCurrent();
				},

				// 音频编辑页 － 搜索专辑 － 回调 处理
				bringBackAudioAlbumPid : function(args) {
					var $box = navTab.getCurrentPanel();
					var $pid = $('#pid', $box);
					$pid.each(function() {
						$pid.val(args['pid']);
					});
					$.pdialog.closeCurrent();
				},

				// 看点回调
				bringBackByWatchingFocus : function(args) {
					var str = [], $box = $('#watching_focus'), local_data = [];
					$box.find('input[type="hidden"]').each(function(i) {
						local_data.push(this.value);
					});

					$
							.each(
									args,
									function(k, obj) {
										if ($.inArray(obj.id, local_data) < 0) {
											str
													.push('<p><a href="javascript:;" onclick="remove_watching_focus(this)">'
															+ obj.title
															+ '<b>['
															+ obj.id
															+ ']</b></a><input type="hidden" name="vids" value="'
															+ obj.id
															+ '" /></p>');
										}
									});

					$box.append(str.join(''));
				},
				// 视频列表。 加入到专辑
				bringBackForJoinAlbum : function(args) {
					$.ajax({
						type : 'POST',
						url : '../video/doBatchAddVideoToAlbum.action',
						data : args,
						dataType : "json",
						cache : false,
						success : navTabAjaxDone,
						error : DWZ.ajaxError
					});
					// navTab.reload(json.forwardUrl, {navTabId:
					// json.navTabId});
					$.pdialog.closeCurrent();
				},
				// 音频列表。 加入到专辑
				bringBackAudioForJoinAlbum : function(args) {
					$.ajax({
						type : 'POST',
						url : '../audio/batchAddToAlbum.action',
						data : args,
						dataType : "json",
						cache : false,
						success : navTabAjaxDone,
						error : DWZ.ajaxError
					});
					// navTab.reload(json.forwardUrl, {navTabId:
					// json.navTabId});
					$.pdialog.closeCurrent();
				},

				// 豆瓣视频弹窗回调处理
				bringBackByDoubanVideo : function(args) {
					$.pdialog.closeCurrent();
				},

				// 专辑弹窗回调处理
				bringBackByRelationAlbum : function(args) {
					var $box = navTab.getCurrentPanel();
					var pid = args.pid;
					var name = args.name;

					// var size
					// =$("#relationAlbumDiv",$box).find('input[type="hidden"]').length;
					$
							.ajax({
								type : 'POST',
								url : '../album/getRelationIds.action?pid='
										+ pid,
								// data: pid,
								dataType : "json",
								cache : false,
								success : function(args) {
									var dataTemp = args.data;
									for (t in dataTemp) {
										var hasIt = true;
										$("#relationAlbumDiv", $box)
												.find('input[type="hidden"]')
												.each(
														function(i) {
															if (this.value == dataTemp[t].pid) {
																hasIt = false;
															}
														});
										if (hasIt) {
											$("#relationAlbumDiv", $box)
													.append(
															'<div><a href="javascript:;" onclick="remove_watching_focus(this)"><div class="dipc">'
																	+ dataTemp[t].name
																	+ '<span></span><input type="hidden" name="albumRelationId" value="'
																	+ dataTemp[t].pid
																	+ '"/></div></a></div>');
										}
										$.pdialog.closeCurrent();
									}
								},
								error : DWZ.ajaxError
							});

					// if(size>10){
					// alertMsg.warn('关联专辑数最大为10！');
					// return false;
					// }
					// $("#relationAlbumDiv",$box).find('input[type="hidden"]').each(function(i){
					// if(this.value == pid){
					// hasIt = false;
					// }
					// });
					// if(hasIt){
					// $("#relationAlbumDiv",$box).append('<div><a
					// href="javascript:;"
					// onclick="remove_watching_focus(this)"><div
					// class="dipc">'+name+'<span></span><input type="hidden"
					// name="albumRelationId"
					// value="'+pid+'"/></div></a></div>');
					//				
					// $.pdialog.closeCurrent();
					// }else{
					// alertMsg.warn('关联专辑中已经存在该记录！');
					// return false;
					// }

				}
			});

	$.fn
			.extend({
				lookupforvideo : function() {
					return this
							.each(function() {
								var $this = $(this), options = {
									mask : true,
									width : $this.attr('width') || 820,
									height : $this.attr('height') || 400,
									maxable : eval($this.attr("maxable")
											|| "true"),
									resizable : eval($this.attr("resizable")
											|| "true")
								};
								$this
										.click(function(event) {
											_lookup = $.extend(_lookup, {
												currentGroup : $this
														.attr("lookupforvideo")
														|| "",
												suffix : $this.attr("suffix")
														|| "",
												$target : $this,
												pk : $this.attr("lookupPk")
														|| "id"
											});
											var $box = navTab.getCurrentPanel();
											var $checkboxLi = $(
													"input['name=vids']:checked",
													$box), ids = [];
											$checkboxLi
													.each(function() {
														$checkbox = $(this);
														if ($checkbox
																.is(":checked")) {
															if ($checkbox.val() != 'on') { // 全选文本框会是on
																ids
																		.push($checkbox
																				.val());
															}
														}
													});

											if (ids.length < 1) {
												alertMsg
														.warn('请先从视频列表中勾选相应的记录，再进行此操作');
												return false;
											}
											for (var i = 0, size = ids.length; i < size; i++) {
												for (var j = 0, l = $(".havePid").length; j < l; j++) {
													if (ids[i] == $(".havePid")[j].value) {
														alertMsg
																.warn("id_"
																		+ ids[i]
																		+ ' 此视频已加入专辑，不能重复加入');
														return false;
													}
												}
											}
											var url = unescape(
													$this.attr("href"))
													.replaceTmById(
															$(event.target)
																	.parents(
																			".unitBox:first"));
											if (!url.isFinishedTm()) {
												alertMsg
														.error($this
																.attr("warn")
																|| DWZ
																		.msg("alertSelectMsg"));
												return false;
											}

											$.pdialog.open(url + '&vids='
													+ ids.join(','), "_blank",
													$this.attr("title")
															|| $this.text(),
													options);
											return false;
										});
							});
				},
				lookupforaudio : function() {
					return this
							.each(function() {
								var $this = $(this), options = {
									mask : true,
									width : $this.attr('width') || 820,
									height : $this.attr('height') || 400,
									maxable : eval($this.attr("maxable")
											|| "true"),
									resizable : eval($this.attr("resizable")
											|| "true")
								};
								$this
										.click(function(event) {
											_lookup = $.extend(_lookup, {
												currentGroup : $this
														.attr("lookupforaudio")
														|| "",
												suffix : $this.attr("suffix")
														|| "",
												$target : $this,
												pk : $this.attr("lookupPk")
														|| "id"
											});

											var $box = navTab.getCurrentPanel();
											var $checkboxLi = $(
													"input['name=vids']:checked",
													$box), ids = [];
											$checkboxLi.each(function() {
												$checkbox = $(this);
												if ($checkbox.is(":checked")) {
													ids.push($checkbox.val());
												}
											});

											if (ids.length < 1) {
												alertMsg
														.warn('请先从视频列表中勾选相应的记录，再进行此操作');
												return false;
											}
											for (var i = 0, size = ids.length; i < size; i++) {
												for (var j = 0, l = $(".havePid").length; j < l; j++) {
													if (ids[i] == $(".havePid")[j].value) {
														alertMsg
																.warn("id_"
																		+ ids[i]
																		+ ' 此因频已加入专辑，不能重复加入');
														return false;
													}
												}
											}
											var url = unescape(
													$this.attr("href"))
													.replaceTmById(
															$(event.target)
																	.parents(
																			".unitBox:first"));
											if (!url.isFinishedTm()) {
												alertMsg
														.error($this
																.attr("warn")
																|| DWZ
																		.msg("alertSelectMsg"));
												return false;
											}

											$.pdialog.open(url + '&vids='
													+ ids.join(','), "_blank",
													$this.attr("title")
															|| $this.text(),
													options);
											return false;
										});
							});
				},
				lookup : function() {
					return this.each(function() {
						var $this = $(this), options = {
							mask : true,
							width : $this.attr('width') || 820,
							height : $this.attr('height') || 400,
							maxable : eval($this.attr("maxable") || "true"),
							resizable : eval($this.attr("resizable") || "true")
						};
						$this.click(function(event) {
							_lookup = $.extend(_lookup, {
								currentGroup : $this.attr("lookupGroup") || "",
								suffix : $this.attr("suffix") || "",
								$target : $this,
								pk : $this.attr("lookupPk") || "id"
							});
							// 额外验证专辑部分的添加视频功能
							if ($this.attr("lookupGroup") === 'addVideoGroup') {
								var $box = navTab.getCurrentPanel();
								var pidCount = 0;
								$("input['name=vids']:checked", $box).find(
										":hasPid").each(function() {
									pidCount++;
								})

								// var iCount = $('.changed').length;
								if (pidCount > 0) {
									alertMsg.warn('视频列表中存在已修改的记录，请保存后再进行添加视频');
									return false;
								}
							}
							// 额外验证专辑部分的添加视频功能
							if ($this.attr("lookupGroup") === 'addAudioGroup') {
								var $box = navTab.getCurrentPanel();
								var pidCount = 0;
								$("input['name=vids']:checked", $box).find(
										":hasPid").each(function() {
									pidCount++;
								})

								// var iCount = $('.changed').length;
								if (pidCount > 0) {
									alertMsg.warn('视频列表中存在已修改的记录，请保存后再进行添加视频');
									return false;
								}
							}

							var url = unescape($this.attr("href"))
									.replaceTmById(
											$(event.target).parents(
													".unitBox:first"));
							if (!url.isFinishedTm()) {
								alertMsg.error($this.attr("warn")
										|| DWZ.msg("alertSelectMsg"));
								return false;
							}

							$.pdialog.open(url, "_blank", $this.attr("title")
									|| $this.text(), options);
							return false;
						});
					});
				},
				multLookup : function() {
					return this
							.each(function() {
								var $this = $(this), flag = $this.attr('flag'), cid = $this
										.attr('cid'), aid = $this.attr('aid'), args = {}, return_data = [];
								$this
										.click(function(event) {
											var $unitBox = $this
													.parents(".unitBox:first"), vids = [];
											$unitBox
													.find(
															"[name='"
																	+ $this
																			.attr("multLookup")
																	+ "']")
													.filter(":checked")
													.each(
															function() {
																vids.push($(
																		this)
																		.val());// 用于定制的回调

																var _args = DWZ
																		.jsonEval($(
																				this)
																				.val());
																return_data
																		.push(_args);
																for ( var key in _args) {
																	var value = args[key] ? args[key]
																			+ ","
																			: "";
																	args[key] = value
																			+ _args[key];
																}
															});

											if ('watching_focus_multLookup' === flag) {
												if ($
														.isEmptyObject(return_data)) {
													alertMsg.error($this
															.attr("warn"));
													return false;
												}

												$
														.bringBackByWatchingFocus(return_data);
											}
											// 2013年3月19日：扩展lookup 多选功能的回调处理
											else if ('video_multLookup' === flag) {
												if ($.isEmptyObject(vids)) {
													alertMsg.error($this
															.attr("warn"));
													return false;
												}

												$.bringBackByAlbumAddVideo({
													aid : aid,
													vids : vids.join(','),
													flag : 1,
													cid : cid
												});
											}
											// 2015年3月31日：扩展lookup 专辑添加音频选择带回
											else if ('audio_multLookup' === flag) {
												if ($.isEmptyObject(vids)) {
													alertMsg.error($this
															.attr("warn"));
													return false;
												}

												$
														.bringBackByAudioAlbumAddAudio({
															aid : aid,
															ids : vids
																	.join(','),
															forwardPage : "albumAudioList"
																	+ aid,
															cid : cid
														});
											}
											// 扩展多选 lookup 多选功能的回调处理
											else if ('batch_edit' === flag) {
												if ($.isEmptyObject(vids)) {
													alertMsg.error($this
															.attr("warn"));
													return false;
												}
												var c_name = $this
														.attr('cname');
												navTab
														.openTab(
																'batchEdit'
																		+ aid,
																'../video/forwardBatch.action?vids='
																		+ vids
																				.join(',')
																		+ '&cid='
																		+ aid
																		+ '&r='
																		+ Math
																				.random(),
																{
																	title : c_name
																			+ ' - 视频批量修改',
																	fresh : false,
																	data : {}
																});
											} // 扩展体育频道的lookup多选功能
											else if ('album_multLookup' === flag) {
												var ids = vids.join(',');
												if ($.isEmptyObject(vids)) {
													alertMsg.error($this
															.attr("warn"));
													return false;
												}
												$.bringBack({
													clonepid : ids
												});

												// 验证返回的ID是不是5个,是不是存在
												if (vids.length > 5) {
													alertMsg
															.warn(
																	'专辑个数不能超过5个。',
																	{
																		okCall : function() {
																			$(
																					'#clonepid',
																					navTab
																							.getCurrentPanel())
																					.select();
																		}
																	});

													return false;
												}
											} else if ('videoShield_multLookup' === flag) {
												var ids = vids.join(',');
												if ($.isEmptyObject(vids)) {
													alertMsg.error($this
															.attr("warn"));
													return false;
												}

												$.bringBackSuggest1({
													videoIds : ids
												});
												$.pdialog.closeCurrent();
											} else if ('batch_multLookup' === flag) {
												var ids = vids.join(',');
												if ($.isEmptyObject(vids)) {
													alertMsg.error($this
															.attr("warn"));
													return false;
												}

												$.bringBackSuggest1({
													videoIds : ids
												});
												$.pdialog.closeCurrent();
											} else if ('tv_multLookup' === flag) {
												var idsNames = vids.join(',');
												if ($.isEmptyObject(idsNames)) {
													alertMsg.error($this
															.attr("warn"));
													return false;
												}
												if (vids.length > 3) {
													alertMsg.error("个数不能超过三个");
													return false;
												}
												var idsNamesArr = new Array();
												var idNameArr = new Array();
												var ids = "", names = "";
												idsNamesArr = idsNames
														.split(",");
												if (idsNamesArr.length >= 1) {
													for (i in idsNamesArr) {
														idNameArr = idsNamesArr[i]
																.split(" _ ");
														if (i == idsNamesArr.length - 1) {
															ids = ids
																	+ idNameArr[0];
															names = names
																	+ idNameArr[1];
														} else {
															ids = ids
																	+ idNameArr[0]
																	+ ",";
															names = names
																	+ idNameArr[1]
																	+ ",";
														}
													}
												}
												$.bringBackSuggest({
													tvId : ids,
													tvName : names
												});
												$.pdialog.closeCurrent();
											} else if ('video_relation_album_multLookup' === flag) {
												var $box = navTab
														.getCurrentPanel();
												var idsNames = vids.join(',');
												if ($.isEmptyObject(vids)) {
													alertMsg.error($this
															.attr("warn"));
													return false;
												}
												// if (vids.length > 10) {
												// alertMsg.error("个数不能超过10个");
												// return false;
												// }
												// if
												// ($("#relationAlbumDiv",$box).find('input[type="hidden"]').length
												// + vids.length > 10) {
												// alertMsg.error("总数不能超过10个");
												// return false;
												// }
												var idsNamesArr = new Array();
												var idNameArr = new Array();
												var ids = "", names = "";
												idsNamesArr = idsNames
														.split(",");
												if (idsNamesArr.length >= 1) {
													for (i in idsNamesArr) {
														idNameArr = idsNamesArr[i]
																.split(" _ ");
														var pid = idNameArr[0];
														var name = idNameArr[1];
														var hasIt = true;
														$("#relationAlbumDiv",
																$box)
																.find(
																		'input[type="hidden"]')
																.each(
																		function(
																				i) {
																			if (this.value == pid) {
																				hasIt = false;
																			}
																		});
														if (hasIt) {
															$(
																	"#relationAlbumDiv",
																	$box)
																	.append(
																			'<div><a href="javascript:;" onclick="remove_watching_focus(this)"><div class="dipc">'
																					+ name
																					+ '<span></span><input type="hidden" name="albumRelationId" value="'
																					+ pid
																					+ '"/></div></a></div>');
														}
														$.pdialog
																.closeCurrent();

													}
												}
												$.bringBackSuggest({
													tvId : ids,
													tvName : names
												});
												$.pdialog.closeCurrent();
											} else if ('copyright_multLookup' === flag) {
													var $box = navTab
															.getCurrentPanel();
													var idsNames = vids.join(',');
													if ($.isEmptyObject(vids)) {
														alertMsg.error($this
																.attr("warn"));
														return false;
													}
													// if (vids.length > 10) {
													// alertMsg.error("个数不能超过10个");
													// return false;
													// }
													// if
													// ($("#relationAlbumDiv",$box).find('input[type="hidden"]').length
													// + vids.length > 10) {
													// alertMsg.error("总数不能超过10个");
													// return false;
													// }
													var idsNamesArr = new Array();
													var idNameArr = new Array();
													var ids = "", names = "";
													idsNamesArr = idsNames
															.split(",");
													if (idsNamesArr.length >= 1) {
														for (i in idsNamesArr) {
															idNameArr = idsNamesArr[i]
																	.split(" _ ");
															var copyrightCode = idNameArr[0];
															var copyrightName = idNameArr[1];
															var hasIt = true;
															$("#relationCopyRightDiv",
																	$box)
																	.find(
																			'input[type="hidden"]')
																	.each(
																			function(
																					i) {
																				if (this.value == copyrightCode) {
																					hasIt = false;
																				}
																			});
															if (hasIt) {
																$(
																		"#relationCopyRightDiv",
																		$box)
																		.append('<div style="float:left"><a href="javascript:;" onclick="remove_watching_focus(this)"><div class="dipc">' 
																				+ copyrightName 
																				+ '<span></span><input type="hidden" name="copyrightCode" value="' 
																				+ copyrightCode 
																				+ '"/></div></a><a title="' 
																				+ copyrightName 
																				+ '" target="navTab" href="../album/detailInfo.action?copyRightCode=' 
																				+ copyrightCode 
																				+ '&flag=0"><span><img src="../themes/default/images/lookup.jpg"/></span></a></div>');
															}
															$.pdialog
																	.closeCurrent();

														}
													}
													$.bringBackSuggest({
														tvId : ids,
														tvName : names
													});
													$.pdialog.closeCurrent();
											} else if ('leCi_query_multLookup' === flag) {
												var $box = navTab
														.getCurrentPanel();
												var leciLevel = $this
														.attr('leciLevel')
												var idsNames = vids.join(',');
												if ($.isEmptyObject(vids)) {
													alertMsg.error($this
															.attr("warn"));
													return false;
												}
												// if
												// ($("#leIdDiv",$box).find('input[type="hidden"]').length
												// + vids.length > 10) {
												// alertMsg.error("总数不能超过10个");
												// return false;
												// }
												var idsNamesArr = new Array();
												var idNameArr = new Array();
												var ids = "", names = "";
												idsNamesArr = idsNames
														.split(",");
												if (idsNamesArr.length >= 1) {
													for (i in idsNamesArr) {
														idNameArr = idsNamesArr[i]
																.split(" _ ");
														var id = idNameArr[0];
														var name = idNameArr[1];
														var hasIt = true;
														$("#leIdImportDiv",
																$box)
																.find(
																		'input[type="hidden"]')
																.each(
																		function(
																				i) {
																			if (this.value == id) {
																				hasIt = false;
																			}
																		});
														$("#leIdCommonDiv",
																$box)
																.find(
																		'input[type="hidden"]')
																.each(
																		function(
																				i) {
																			if (this.value == id) {
																				hasIt = false;
																			}
																		});
														$("#leIdSecondaryDiv",
																$box)
																.find(
																		'input[type="hidden"]')
																.each(
																		function(
																				i) {
																			if (this.value == id) {
																				hasIt = false;
																			}
																		});
														if (hasIt) {
															$(
																	"#"
																			+ leciLevel
																			+ "Div",
																	$box)
																	.append(
																			'<div><a href="javascript:;" onclick="remove_watching_focus(this)"><div class="dipc">'
																					+ name
																					+ '<span></span><input type="hidden" name='
																					+ leciLevel
																					+ ' value="'
																					+ id
																					+ '"/></div></a></div>');
														}
														$.pdialog
																.closeCurrent();

													}
												}
												$.bringBackSuggest({
													tvId : ids,
													tvName : names
												});
												$.pdialog.closeCurrent();
											} else if ('douban_query_multLookup' === flag) {
												// alert("dfdfdf");
												var $box = navTab
														.getCurrentPanel();
												var leciLevel = $this
														.attr('leciLevel')
												var idsNames = vids.join(',');
												if ($.isEmptyObject(vids)) {
													alertMsg.error($this
															.attr("warn"));
													return false;
												}
												var radio = $(
														'input[name="orgId"]:checked')
														.val();
												$("#score", $box).val(radio);
												// alert($('input[name="orgId"]:checked').parent().find('input[name="douban"]').val());
												$("#doubanId", $box)
														.val(
																$(
																		'input[name="orgId"]:checked')
																		.parent()
																		.find(
																				'input[name="douban"]')
																		.val());
												$("#leIdCommonDiv", $box).html(
														"");
												$("#score", $box).val(radio);
												$.bringBackSuggest({
													tvId : ids,
													tvName : names
												});
												$.pdialog.closeCurrent();
											} else {
												if ($.isEmptyObject(args)) {
													alertMsg
															.error($this
																	.attr("warn")
																	|| DWZ
																			.msg("alertSelectMsg"));
													return false;
												}
											}

										});
							});
				},
				suggest : function() {
					var op = {
						suggest$ : "#suggest",
						suggestShadow$ : "#suggestShadow"
					};
					var selectedIndex = -1;
					return this
							.each(function() {
								var $input = $(this)
										.attr('autocomplete', 'off')
										.keydown(
												function(event) {
													if (event.keyCode == DWZ.keyCode.ENTER
															&& $(op.suggest$)
																	.is(
																			':visible'))
														return false; // 屏蔽回车提交
												});

								var suggestFields = $input
										.attr('suggestFields').split(",");

								function _show(event) {
									var offset = $input.offset();
									var iTop = offset.top + this.offsetHeight;
									var $suggest = $(op.suggest$);
									if ($suggest.size() == 0)
										$suggest = $('<div id="suggest"></div>')
												.appendTo($('body'));

									$suggest.css({
										left : offset.left + 'px',
										top : iTop + 'px'
									}).show();

									_lookup = $.extend(_lookup, {
										currentGroup : $input
												.attr("lookupGroup")
												|| "",
										suffix : $input.attr("suffix") || "",
										$target : $input,
										pk : $input.attr("lookupPk") || "id"
									});

									var url = unescape(
											$input.attr("suggestUrl"))
											.replaceTmById(
													$(event.target).parents(
															".unitBox:first"));
									if (!url.isFinishedTm()) {
										alertMsg.error($input.attr("warn")
												|| DWZ.msg("alertSelectMsg"));
										return false;
									}

									var postData = {};
									postData[$input.attr("postField")
											|| "inputValue"] = $input.val();

									$
											.ajax({
												global : false,
												type : 'POST',
												dataType : "json",
												url : url,
												cache : false,
												data : postData,
												success : function(response) {
													if (!response)
														return;
													var html = '';

													$
															.each(
																	response,
																	function(i) {
																		var liAttr = '', liLabel = '';

																		for (var i = 0; i < suggestFields.length; i++) {
																			var str = this[suggestFields[i]];
																			if (str) {
																				if (liLabel)
																					liLabel += '-';
																				liLabel += str;
																			}
																		}
																		for ( var key in this) {
																			if (liAttr)
																				liAttr += ',';
																			liAttr += key
																					+ ":'"
																					+ this[key]
																					+ "'";
																		}
																		html += '<li lookupAttrs="'
																				+ liAttr
																				+ '">'
																				+ liLabel
																				+ '</li>';
																	});

													var $lis = $suggest.html(
															'<ul>' + html
																	+ '</ul>')
															.find("li");
													$lis
															.hoverClass(
																	"selected")
															.click(
																	function() {
																		_select($(this));
																	});
													if ($lis.size() == 1
															&& event.keyCode != DWZ.keyCode.BACKSPACE) {
														// _select($lis.eq(0));
														// 去掉自动完成功能
													} else if ($lis.size() == 0) {
														var jsonStr = "";
														for (var i = 0; i < suggestFields.length; i++) {
															if (_util
																	.lookupField(suggestFields[i]) == event.target.name) {
																break;
															}
															if (jsonStr)
																jsonStr += ',';
															jsonStr += suggestFields[i]
																	+ ":''";
														}
														jsonStr = "{"
																+ _lookup.pk
																+ ":'',"
																+ jsonStr + "}";
														$
																.bringBackSuggest(DWZ
																		.jsonEval(jsonStr));
													}
												},
												error : function() {
													$suggest.html('');
												}
											});

									$(document).bind("click", _close);
									return false;
								}
								function _select($item) {
									var jsonStr = "{"
											+ $item.attr('lookupAttrs') + "}";
									$.bringBackSuggest(DWZ.jsonEval(jsonStr));
									// 2013年12月18日 选择框回填数据
									if ($input.attr('callback')) {
										$.bringBackindexSuggest(DWZ
												.jsonEval(jsonStr));
									}
									// 2013年5月30日 选择成功之后立刻检测明星是否存在
									if ($input.attr('onblur')) {
										onblurs($input[0], $input.val());
									}
								}
								function _close() {
									$(op.suggest$).html('').hide();
									selectedIndex = -1;
									$(document).unbind("click", _close);
								}

								$input.focus(_show).click(false).keyup(
										function(event) {
											var $items = $(op.suggest$).find(
													"li");
											switch (event.keyCode) {
											case DWZ.keyCode.ESC:
											case DWZ.keyCode.TAB:
											case DWZ.keyCode.SHIFT:
											case DWZ.keyCode.HOME:
											case DWZ.keyCode.END:
											case DWZ.keyCode.LEFT:
											case DWZ.keyCode.RIGHT:
												break;
											case DWZ.keyCode.ENTER:
												_close();
												break;
											case DWZ.keyCode.DOWN:
												if (selectedIndex >= $items
														.size() - 1)
													selectedIndex = -1;
												else
													selectedIndex++;
												break;
											case DWZ.keyCode.UP:
												if (selectedIndex < 0)
													selectedIndex = $items
															.size() - 1;
												else
													selectedIndex--;
												break;
											default:
												_show(event);
											}
											$items.removeClass("selected");
											if (selectedIndex >= 0) {
												var $item = $items.eq(
														selectedIndex)
														.addClass("selected");
												_select($item);
											}
										});
							});
				},

				itemDetail : function() {
					return this
							.each(function() {
								var $table = $(this).css("clear", "both"), $tbody = $table
										.find("tbody");
								var fields = [];
								var bodyid = $tbody.attr('id');

								$table
										.find("tr:first th[type]")
										.each(
												function(i) {
													var $th = $(this);
													var field = {
														type : $th.attr("type")
																|| "text",
														patternDate : $th
																.attr("format")
																|| "yyyy-MM-dd",
														name : $th.attr("name")
																|| "",
														defaultVal : $th
																.attr("defaultVal")
																|| "",
														size : $th.attr("size")
																|| "12",
														enumUrl : $th
																.attr("enumUrl")
																|| "",
														lookupGroup : $th
																.attr("lookupGroup")
																|| "",
														lookupUrl : $th
																.attr("lookupUrl")
																|| "",
														lookupPk : $th
																.attr("lookupPk")
																|| "id",
														suggestUrl : $th
																.attr("suggestUrl"),
														suggestFields : $th
																.attr("suggestFields"),
														postField : $th
																.attr("postField")
																|| "",
														fieldClass : $th
																.attr("fieldClass")
																|| "",
														fieldAttrs : $th
																.attr("fieldAttrs")
																|| ""
													};
													fields.push(field);
												});

								$tbody
										.find("a.btnDel")
										.click(
												function() {
													var $btnDel = $(this);

													if ($btnDel
															.is("[href^=javascript:]")) {
														$btnDel.parents(
																"tr:first")
																.remove();
														initSuffix($tbody);
														return false;
													}

													function delDbData() {
														$
																.ajax({
																	type : 'POST',
																	dataType : "json",
																	url : $btnDel
																			.attr('href'),
																	cache : false,
																	success : function() {
																		$btnDel
																				.parents(
																						"tr:first")
																				.remove();
																		initSuffix($tbody);
																	},
																	error : DWZ.ajaxError
																});
													}

													if ($btnDel.attr("title")) {
														alertMsg
																.confirm(
																		$btnDel
																				.attr("title"),
																		{
																			okCall : delDbData
																		});
													} else {
														delDbData();
													}

													return false;
												});

								var addButTxt = $table.attr('addButton')
										|| "Add New";
								if (addButTxt) {
									var $addBut = $(
											'<div class="button"><div class="buttonContent"><button type="button">'
													+ addButTxt
													+ '</button></div></div>')
											.insertAfter($table).find("button");
									var $rowNum = $(
											'<input type="text" name="dwz_rowNum" class="textInput" style="margin:2px;display:none;" value="1" size="2"/>')
											.insertBefore($table);

									var trTm = "";
									$addBut
											.click(function() {
												var tbody = $(this).parent()
														.parent().parent()
														.find("tbody");
												if (check(tbody) == true) {
													if (!trTm)
														trTm = trHtml(fields);
													var rowNum = 1;
													try {
														rowNum = parseInt($rowNum
																.val())
													} catch (e) {
													}

													for (var i = 0; i < rowNum; i++) {
														var $tr = $(trTm);
														$tr
																.appendTo(
																		$tbody)
																.initUI()
																.find(
																		"a.btnDel")
																.click(
																		function() {
																			$(
																					this)
																					.parents(
																							"tr:first")
																					.remove();
																			initSuffix($tbody);
																			return false;
																		});

														$tr
																.appendTo(
																		$tbody)
																.initUI()
																.find(
																		"a.btnDel")
																.click(
																		function() {
																			$(
																					this)
																					.parents(
																							"tr:first")
																					.remove();
																			initSuffix($tbody);
																			return false;
																		});
													}
													initSuffix($tbody);
												}
											});
								}
							});

					/**
					 * 删除时重新初始化下标
					 */
					function initSuffix($tbody) {
						$tbody
								.find('>tr')
								.each(
										function(i) {
											$(':input, a.btnLook', this)
													.each(
															function() {
																var $this = $(this), name = $this
																		.attr('name'), val = $this
																		.val();

																if (name)
																	$this
																			.attr(
																					'name',
																					name
																							.replaceSuffix(i));

																var lookupGroup = $this
																		.attr('lookupGroup');
																if (lookupGroup) {
																	$this
																			.attr(
																					'lookupGroup',
																					lookupGroup
																							.replaceSuffix(i));
																}

																var suffix = $this
																		.attr("suffix");
																if (suffix) {
																	$this
																			.attr(
																					'suffix',
																					suffix
																							.replaceSuffix(i));
																}

																if (val
																		&& val
																				.indexOf("#index#") >= 0)
																	$this
																			.val(val
																					.replace(
																							'#index#',
																							i + 1));
															});
										});
					}

					function tdHtml(field) {
						var html = '', suffix = '';
						if (field.name.endsWith("[#index#]"))
							suffix = "[#index#]";
						else if (field.name.endsWith("[]"))
							suffix = "[]";

						var suffixFrag = suffix ? ' suffix="' + suffix + '" '
								: '';

						var attrFrag = '';
						if (field.fieldAttrs) {
							var attrs = DWZ.jsonEval(field.fieldAttrs);
							for ( var key in attrs) {
								attrFrag += key + '="' + attrs[key] + '"';
							}
						}
						switch (field.type) {
						case 'del':
							html = '<a href="javascript:void(0)" class="btnDel '
									+ field.fieldClass + '">删除</a>';
							break;
						case 'lookup':
							var suggestFrag = '';
							if (field.suggestFields) {
								suggestFrag = 'autocomplete="off" lookupGroup="'
										+ field.lookupGroup
										+ '"'
										+ suffixFrag
										+ ' suggestUrl="'
										+ field.suggestUrl
										+ '" suggestFields="'
										+ field.suggestFields
										+ '"'
										+ ' postField="'
										+ field.postField
										+ '"';
							}

							html = '<input type="hidden" name="'
									+ field.lookupGroup + '.' + field.lookupPk
									+ suffix + '"/>'
									+ '<input type="text" name="' + field.name
									+ '"' + suggestFrag + ' lookupPk="'
									+ field.lookupPk + '" size="' + field.size
									+ '" class="' + field.fieldClass + '"/>'
									+ '<a class="btnLook" href="'
									+ field.lookupUrl + '" lookupGroup="'
									+ field.lookupGroup + '" ' + suggestFrag
									+ ' lookupPk="' + field.lookupPk
									+ '" title="查找带回">查找带回</a>';
							break;
						case 'attach':
							html = '<input type="hidden" name="'
									+ field.lookupGroup
									+ '.'
									+ field.lookupPk
									+ suffix
									+ '"/>'
									+ '<input type="text" name="'
									+ field.name
									+ '" size="'
									+ field.size
									+ '" readonly="readonly" class="'
									+ field.fieldClass
									+ '"/>'
									+ '<a class="btnAttach" href="'
									+ field.lookupUrl
									+ '" lookupGroup="'
									+ field.lookupGroup
									+ '" '
									+ suggestFrag
									+ ' lookupPk="'
									+ field.lookupPk
									+ '" width="560" height="300" title="查找带回">查找带回</a>';
							break;
						case 'enum':
							$.ajax({
								type : "POST",
								dataType : "html",
								async : false,
								url : field.enumUrl,
								data : {
									inputName : field.name
								},
								success : function(response) {
									html = response;
								}
							});
							break;
						case 'date':
							html = '<input type="text" name="'
									+ field.name
									+ '" value="'
									+ field.defaultVal
									+ '" class="date '
									+ field.fieldClass
									+ '" format="'
									+ field.patternDate
									+ '" size="'
									+ field.size
									+ '"/>'
									+ '<a class="inputDateButton" href="javascript:void(0)">选择</a>';
							break;
						default:
							var fname = field.name;
							if (fname == "album.directory"
									|| fname == "actors.key"
									|| fname == "starrings.key"
									|| fname == "directorys.key"
									|| fname == "compere.key"
									|| fname == "star.directory"
									|| fname == "actor.directory"
									|| fname == "instructor.key"
									|| fname == "originator.key"
									|| fname == "supervise.key"
									|| fname == "singer.key") {
								if (field.suggestFields) {
									suggestFrag = 'autocomplete="off" lookupGroup="'
											+ field.lookupGroup
											+ '"'
											+ suffixFrag
											+ ' suggestUrl="'
											+ field.suggestUrl
											+ '" suggestFields="'
											+ field.suggestFields
											+ '"'
											+ ' postField="'
											+ field.postField
											+ '"';
								}
								html = '<input type="hidden" name="'
										+ field.lookupGroup
										+ '.'
										+ field.lookupPk
										+ '"/>'
										+ '<input onblur="onblurs(this,this.value)" type="text" name="'
										+ field.name + '"' + suggestFrag
										+ ' size="' + field.size + '" class="'
										+ field.fieldClass + '"/>';

								// 定妆照
								if (fname == "star.directory") {
									html += '<input type="hidden" class="dzzsrcs" value="无" name="starringPics">';
								} else if ("actor.directory" == fname) {
									html += '<input type="hidden" class="dzzsrcs"  value="无" name="actorPics" >';
								}
							} else {
								html = '<input type="text" name="' + field.name
										+ '" value="' + field.defaultVal
										+ '" size="' + field.size + '" class="'
										+ field.fieldClass + '" ' + attrFrag
										+ '/>';
							}

							break;
						}
						return '<td>' + html + '</td>';
					}

					function trHtml(fields) {
						var html = '';
						$(fields).each(function() {
							html += tdHtml(this);
						});
						return '<tr class="unitBox">' + html + '</tr>';
					}

					function check(tbody) {
						var res = true;
						$(tbody).find("tr").each(
								function(i, n) {
									var txts = $(this).find(
											"input[type='text']");
									var t1 = txts.eq(0), val = t1.val() + '';
									if (val.length <= 0) {
										res = false;
										t1.focus();
										return false;
									}

									if (txts.get(1) != undefined
											&& txts.get(1).value.length <= 0) {
										txts.get(1).value = "";// 我改了！！！原来是无
									}
								});

						return res;
					}
				},

				selectedTodo : function() {

					function _getIds(selectedIds, targetType) {
						var ids = "";
						var $box = targetType == "dialog" ? $.pdialog
								.getCurrent() : navTab.getCurrentPanel();
						$box.find("input:checked").filter(
								"[name='" + selectedIds + "']").each(
								function(i) {
									var val = $(this).val();
									ids += i == 0 ? val : "," + val;
								});
						return ids;
					}
					return this.each(function() {
						var $this = $(this);
						var selectedIds = $this.attr("rel") || "ids";
						var postType = $this.attr("postType") || "map";

						$this.click(function() {
							var targetType = $this.attr("targetType");
							var ids = _getIds(selectedIds, targetType);
							if (!ids) {
								alertMsg.error($this.attr("warn")
										|| DWZ.msg("alertSelectMsg"));
								return false;
							}

							var _callback = $this.attr("callback")
									|| (targetType == "dialog" ? dialogAjaxDone
											: navTabAjaxDone);
							if (!$.isFunction(_callback))
								_callback = eval('(' + _callback + ')');

							function _doPost() {
								$.ajax({
									type : 'POST',
									url : $this.attr('href'),
									dataType : 'json',
									cache : false,
									data : function() {
										if (postType == 'map') {
											return $.map(ids.split(','),
													function(val, i) {
														return {
															name : selectedIds,
															value : val
														};
													})
										} else {
											var _data = {};
											_data[selectedIds] = ids;
											return _data;
										}
									}(),
									success : _callback,
									error : DWZ.ajaxError
								});
							}
							var title = $this.attr("title");
							if (title) {
								alertMsg.confirm(title, {
									okCall : _doPost
								});
							} else {
								_doPost();
							}
							return false;
						});

					});
				}
			});
})(jQuery);
