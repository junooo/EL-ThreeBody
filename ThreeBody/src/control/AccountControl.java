package control;

import util.R;
import model.Account;

public class AccountControl {
    
    private Account account;

    public R.info login(String id,String password){
        
    	return null;
    }
    
    public R.info logout(){
        return null;
    }
    
    /*
     * 将本地改变上传到服务器端
     */
    public R.info uploadChange(){
    	return null;
    }
    
    /*
     * 将服务器端改变下载
     */
    public R.info downloadChange(){
    	return null;
    }
    
    /*
     * 2015.4.27
     * 凭借缓存的暂时密码在一定时间自动登陆
     */
    public R.info loginByTransientID(){
    	return null;
    }

	public Account getAccount() {
		return account;
	}
}
