package helloandroid.qushi.com.mylistviewdome.TestProtocol;

public class Lawyer implements LLLProtocol {

    private LLLProtocol mILawSuit;

    public Lawyer(LLLProtocol laoluo) {
        this.mILawSuit = laoluo;
    }

    public void setmILawSuit(LLLProtocol mILawSuit) {
        this.mILawSuit = mILawSuit;
    }

    @Override
    public void submit() {
        mILawSuit.submit();
    }

    @Override
    public void burden() {
        mILawSuit.burden();
    }

    @Override
    public void defend() {
        mILawSuit.defend();
    }

    @Override
    public void finish() {
        mILawSuit.finish();
    }

    @Override
    public String baifen() {
        return  "bbbbbbbbbbbbbb";
    }
}
