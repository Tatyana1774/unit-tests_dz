package dz1.calculator;
import com.cdkglobal.criteria.DiscountSlab;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
public class DiscountCalculator {
    private List<DiscountSlab> slabs = new ArrayList<>();

    public DiscountCalculator(List<DiscountSlab> slabs) {
        this.slabs = slabs;
    }

    /*
        This method is used to calculate the discount based on the purchase amount.
     */
    private double discountAmount(final long purchaseAmount) {
        double totalDiscount = 0;
        long balancePurchaseAmount = purchaseAmount;
        //
        slabs.sort((s1, s1) ->  s1.getDiscountMinimumAmount().compare(s2.ge));
        for (DiscountSlab slab : slabs) {
            if (balancePurchaseAmount > slab.getDiscountMinimumAmount()) {
                totalDiscount += slab.getDiscountPercentage() * (balancePurchaseAmount - slab.getDiscountMinimumAmount());
                balancePurchaseAmount = slab.getDiscountMinimumAmount();
            }
        }
        return totalDiscount;
    }
    public long calculateBillingAmount(long purchaseAmount) {
        if (purchaseAmount <= 0) return 0;
        return (long) (purchaseAmount - discountAmount(purchaseAmount));
    }
}