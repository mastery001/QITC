package com.mastery.common;

import java.io.Serializable;
import java.util.Map;

/**
 * @author zxwu
 */
public final class PagingUtil {
    private PagingUtil() {
    }

    /**
	 * 分页支持
	 * 
	 * @param pageSize
	 *            每页记录数
	 * @param recordCount
	 *            总记录数
	 * @param page
	 *            第几页
	 * @param pageOffset
	 *            显示页码范围
	 * @param map
	 *            map
	 * @return 开始行号
	 */
	public static int addPagingSupport(int pageSize, Integer recordCount, Integer page, Integer pageOffset,
            Map<String, Object> map) {
        recordCount = recordCount == null ? 0 : recordCount;
        int pageCount = recordCount / pageSize;
        if (recordCount % pageSize > 0) {
            pageCount++;
        }

        if (page == null) {
            page = 1;
        }
        if (page > pageCount) {
            page = pageCount;
        }
        if (page < 1) {
            page = 1;
        }

		map.put("recordCount", recordCount); // 总记录数
		map.put("pageNum", page); // 第几页
		map.put("pageCount", pageCount); // 总页数
		map.put("numPerPage", pageSize); // 每页记录数

        if (page > 1) {
			map.put("prevPage", page - 1); // 上一页
        }
        if (page < pageCount) {
			map.put("nextPage", page + 1); // 下一页
        }

        if (pageOffset != null) {
            int pageBegin = page - pageOffset;
			map.put("pageBegin", pageBegin < 1 ? 1 : pageBegin); // 显示页码开始

            int pageEnd = page + pageOffset;
			map.put("pageEnd", pageEnd > pageCount ? pageCount : pageEnd); // 显示页码范围结束
        }
        
		int recordBegin = pageSize * (page - 1); // 记录开始数

		return recordBegin;
    }
	
	 /**
		 * 分页支持
		 * 
		 * @param pageSize
		 *            每页记录数
		 * @param recordCount
		 *            总记录数
		 * @param page
		 *            第几页
		 * @param pageOffset
		 *            显示页码范围
		 * @param map
		 *            map
		 * @return 开始行号
		 */
		public static int PagingSupport(int pageSize, Integer recordCount, Integer page, Integer pageOffset,
	            Map<String, Object> map) {
	        recordCount = recordCount == null ? 0 : recordCount;
	        int pageCount = recordCount / pageSize;
	        if (recordCount % pageSize > 0) {
	            pageCount++;
	        }

	        if (page == null) {
	            page = 1;
	        }
	        if (page > pageCount) {
	            page = pageCount;
	        }
	        if (page < 1) {
	            page = 1;
	        }

//			map.put("recordCount", recordCount); // 总记录数
//			map.put("pageNum", page); // 第几页
//			map.put("pageCount", pageCount); // 总页数
//			map.put("numPerPage", pageSize); // 每页记录数

	        if (page > 1) {
				//map.put("prevPage", page - 1); // 上一页
	        }
	        if (page < pageCount) {
				//map.put("nextPage", page + 1); // 下一页
	        }

	        if (pageOffset != null) {
	            int pageBegin = page - pageOffset;
				map.put("pageBegin", pageBegin < 1 ? 1 : pageBegin); // 显示页码开始

	            int pageEnd = page + pageOffset;
				map.put("pageEnd", pageEnd > pageCount ? pageCount : pageEnd); // 显示页码范围结束
	        }
	        
			int recordBegin = pageSize * (page - 1); // 记录开始数

			return recordBegin;
	    }
		
		/**
		 * 分页内部对象
		 * @author zhumingyuan
		 *
		 */
	 public static class PagingVO implements Serializable {

            private static final long serialVersionUID = 1L;
            
            // 总记录数
            private int recordCount ; 
            // 第几页
            private int pageNum ; 
            // 总页数
            private int pageCount; 
            // 每页记录数
            private int numPerPage; 
            // 上一页
            private int prevPage; 
            // 下一页
            private int nextPage; 
            // 显示页码开始
            private int pageBegin; 
            // 显示页码范围结束
            private int pageEnd;
            // sql查询的其实位置
            private int recordBegin;
            
            public int getRecordCount() {
                return recordCount;
            }
            public void setRecordCount(int recordCount) {
                this.recordCount = recordCount;
            }
            public int getPageNum() {
                return pageNum;
            }
            public void setPageNum(int pageNum) {
                this.pageNum = pageNum;
            }
            public int getPageCount() {
                return pageCount;
            }
            public void setPageCount(int pageCount) {
                this.pageCount = pageCount;
            }
            public int getNumPerPage() {
                return numPerPage;
            }
            public void setNumPerPage(int numPerPage) {
                this.numPerPage = numPerPage;
            }
            public int getPrevPage() {
                return prevPage;
            }
            public void setPrevPage(int prevPage) {
                this.prevPage = prevPage;
            }
            public int getNextPage() {
                return nextPage;
            }
            public void setNextPage(int nextPage) {
                this.nextPage = nextPage;
            }
            public int getPageBegin() {
                return pageBegin;
            }
            public void setPageBegin(int pageBegin) {
                this.pageBegin = pageBegin;
            }
            public int getPageEnd() {
                return pageEnd;
            }
            public void setPageEnd(int pageEnd) {
                this.pageEnd = pageEnd;
            }         
            public int getRecordBegin() {
                return recordBegin;
            }
            public void setRecordBegin(int recordBegin) {
                this.recordBegin = recordBegin;
            }
            @Override
            public String toString() {
                return "PagingVO [recordCount=" + recordCount + ", pageNum=" + pageNum
                                + ", pageCount=" + pageCount + ", numPerPage=" + numPerPage
                                + ", prevPage=" + prevPage + ", nextPage=" + nextPage
                                + ", pageBegin=" + pageBegin + ", pageEnd=" + pageEnd
                                + ", recordBegin=" + recordBegin + "]";
            }
                 		    
		}
		
		/**
	     * 分页支持
	     * 
	     * @param pageSize
	     *            每页记录数
	     * @param recordCount
	     *            总记录数
	     * @param page
	     *            第几页
	     * @param pageOffset
	     *            显示页码范围
	     * @param map
	     *            map
	     * @return 开始行号
	     */
	    public static PagingVO getPagingSupport(int pageSize, int recordCount, int page, int pageOffset) {
	        PagingUtil.PagingVO pagingVO = new PagingUtil.PagingVO();
	        int pageCount = recordCount / pageSize;
	        if (recordCount % pageSize > 0) {
	            pageCount++;
	        }

	        if (page <= 0) {
	            page = 1;
	        }
	        if (page > pageCount) {
	            page = pageCount;
	        }
	        if (page < 1) {
	            page = 1;
	        }

	        pagingVO.setRecordCount(recordCount); // 总记录数
	        pagingVO.setPageNum(page); // 第几页
	        pagingVO.setPageCount(pageCount); // 总页数
	        pagingVO.setNumPerPage(pageSize); // 每页记录数

	        if (page > 1) {
	            pagingVO.setPrevPage(page - 1); // 上一页
	        }
	        if (page < pageCount) {
	            pagingVO.setNextPage(page + 1); // 下一页
	        }

	        if (pageOffset > 0) {
	            int pageBegin = page - pageOffset;
	            pagingVO.setPageBegin(pageBegin < 1 ? 1 : pageBegin); // 显示页码开始

	            int pageEnd = page + pageOffset;
	            pagingVO.setPageEnd(pageEnd > pageCount ? pageCount : pageEnd); // 显示页码范围结束
	        }
	        
	        int recordBegin = pageSize * (page - 1); // 记录开始数
	        pagingVO.setRecordBegin(recordBegin);
	        return pagingVO;
	    }
}
