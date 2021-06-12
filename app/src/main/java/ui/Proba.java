package ui;

import android.os.Parcel;
import android.os.Parcelable;

public class Proba implements Parcelable {

    int dates;

    Proba()
    {
        dates = 333;
    }

    protected Proba(Parcel in) {
        dates = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(dates);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Proba> CREATOR = new Creator<Proba>() {
        @Override
        public Proba createFromParcel(Parcel in) {
            return new Proba(in);
        }

        @Override
        public Proba[] newArray(int size) {
            return new Proba[size];
        }
    };

    public int getDates() {
        return dates;
    }

    public void setDates(int dates) {
        this.dates = dates;
    }
}
