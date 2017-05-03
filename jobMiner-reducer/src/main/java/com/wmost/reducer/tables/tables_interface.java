/**
@description  数据表抽象
@author hanse/irene
@data	2017-04-08	00:00	初稿
		2017-04-21	00:00	整理代码
	
**/


package com.wmost.reducer.tables;

public interface tables_interface {
	public String getQuerSQL();

	public String getInsertSQL();
	
	public String getUpdataSQL();
	
	public Object[] getQueryObj();

	public Object[] getUpdataObj();
	
	public Object[] getInsertObj();
}
