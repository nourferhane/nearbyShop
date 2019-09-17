using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace NearbyShop.Models
{
    public class UserShop
    {
        public Shop shop { get; set; }
        public Guid shopId { get; set; }
        public User users { get; set; }
        public Guid userId { get; set; }

    }
}
