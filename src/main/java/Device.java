public class Device {

    String mName;
    String mVersion;

    public Device(String mName, String mVersion) {
        this.mName = mName;
        this.mVersion = mVersion;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getVersion() {
        return mVersion;
    }

    public void setVersion(String mVersion) {
        this.mVersion = mVersion;
    }

}
